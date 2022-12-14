package com.dbms.project.api;

import com.dbms.project.model.CustomerOrder;
import com.dbms.project.model.OrderedProductType;
import com.dbms.project.model.Supplier;
import com.dbms.project.model.SupplierOrder;
import com.dbms.project.service.OrderedProductTypeService;
import com.dbms.project.service.SupplierOrderService;
import com.dbms.project.service.SupplierService;
import com.dbms.project.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.Objects;

// @RequestMapping("api/order/supplier")
@Controller
public class SupplierOrderController {
    private final SupplierOrderService supplierOrderService;
    private final SupplierService supplierService;
    private final ProductTypeService productTypeService;
    private final OrderedProductTypeService orderedProductTypeService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService, SupplierService supplierService, ProductTypeService productTypeService, OrderedProductTypeService orderedProductTypeService) {
        this.supplierOrderService = supplierOrderService;
        this.supplierService = supplierService;
        this.productTypeService = productTypeService;
        this.orderedProductTypeService = orderedProductTypeService;
    }

    @PostMapping(path="/api/order/supplier")
    @ResponseBody
    public void addSupplierOrder(@Valid @NotNull @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.insertSupplierOrder(supplierOrder);
    }

    @GetMapping(path="/api/order/supplier")
    @ResponseBody
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderService.getAllSupplierOrders();
    }

    @PostMapping(path="/order/supplier/{id}/delete")
    public String deleteSupplierOrder(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(id);
        if (!Objects.equals(supplierOrder.getStatus(), "Initiated")) {
            throw new RuntimeException("Cannot add products to a confirmed or completed order");
        }
        supplierOrderService.deleteSupplierOrder(id);
        return "redirect:/order/supplier";
    }

    @GetMapping(path="/order/supplier")
    public String getAllSupplierOrders(Model model) {
        model.addAttribute("orders", supplierOrderService.getAllSupplierOrders());
        return "show-supplier-order";
    }

    @GetMapping(path="/order/supplier/new")
    public String addSupplierOrderForm(Model model) {
        model.addAttribute("orders", new SupplierOrder());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "supplier-order-new";
    }
    @GetMapping(path="/order/supplier/{id}/add")
    public String addProductsToSupplierOrder(@PathVariable("id") int id, Model model) {
        // model.addAttribute("products", productService.getAllProducts());
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(id);
        if (!Objects.equals(supplierOrder.getStatus(), "Initiated")) {
            throw new RuntimeException("Cannot add products to a confirmed or completed order");
        }
        model.addAttribute("supplierOrder", supplierOrderService.getSupplierOrderById(id));
        model.addAttribute("productTypesOrdered", productTypeService.getAllProductTypesInSupplierOrder(id));
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "supplier-order-add-products";
    }
    @PostMapping(path="/order/supplier/")
    public String initializeSupplierOrder(@RequestParam("supplierId") int supplierId, Authentication authentication, RedirectAttributes redirectAttributes) {
        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setSupplierId(supplierId);
        supplierOrder.setDateOfOrder(new Date(System.currentTimeMillis()));
        supplierOrder.setStatus("Initiated");
        supplierOrderService.insertSupplierOrder(supplierOrder);
        return "redirect:/order/supplier/" + supplierOrder.getId() + "/add";
    }

    @PostMapping(path="/order/supplier/{id}/add")
    public String addProductsToSupplierOrder(@PathVariable("id") int supplierOrderId, @RequestParam("quantity") int quantity, @RequestParam("productTypeId") int productTypeId, Authentication authentication, RedirectAttributes redirectAttributes){
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(supplierOrderId);
        if (!Objects.equals(supplierOrder.getStatus(), "Initiated")) {
            throw new RuntimeException("Cannot add products to a confirmed or completed order");
        }
        OrderedProductType orderedProductType = new OrderedProductType();
        orderedProductType.setProductTypeId(productTypeId);
        orderedProductType.setQuantity(quantity);
        orderedProductType.setSupplierOrderId(supplierOrderId);
        orderedProductType.setNumberDelivered(0);
        orderedProductTypeService.insertOrderedProductType(orderedProductType);
        return "redirect:/order/supplier/" + supplierOrderId + "/add";
    }


    @GetMapping(path="/api/order/supplier/{id}")
    @ResponseBody
    public SupplierOrder getSupplierOrderById(@Valid @NotNull @PathVariable("id") int id) {
        return supplierOrderService.getSupplierOrderById(id);
    }

    @PostMapping(path="/api/order/supplier/{id}/edit")
    @ResponseBody
    public void updateSupplierOrder(@PathVariable("id") int id, @Valid @NotNull @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.updateSupplierOrder(id, supplierOrder);
    }

    @PostMapping(path="/order/supplier/{id}/confirm")
    public String confirmSupplierOrder(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(id);
        supplierOrder.setStatus("Confirmed");
        supplierOrderService.updateSupplierOrder(id, supplierOrder);
        return "redirect:/order/supplier/"+id;
    }

    @GetMapping(path="order/supplier/{id}")
    public String showSupplierOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("supplierOrder", supplierOrderService.getSupplierOrderById(id));
        model.addAttribute("productTypesOrdered", productTypeService.getAllProductTypesInSupplierOrder(id));
        System.out.println(supplierOrderService.getSupplierOrderById(id));
        return "supplier-order";
    }

    @PostMapping(path="/order/supplier/{id}/complete")
    public String recieveSupplierOrder(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(id);
        System.out.println(id);
        if (Objects.equals(supplierOrder.getStatus(), "Confirmed")) {
            System.out.println(id);
            supplierOrderService.completeSupplierOrder(id);
            System.out.println("Order Completed");
            supplierOrder.setStatus("Completed");
            supplierOrderService.updateSupplierOrder(id, supplierOrder);
        }
        return "redirect:/order/supplier/";
    }
}
