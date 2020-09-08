package market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
 public class ProductController {

     @Autowired
     ProductRepository productRepository;
//@RequestMapping(value = "/product/productResgist",
//        method = RequestMethod.POST,
//        produces = "application/json;charset=UTF-8")
//
//public void productRegistration(HttpServletRequest request, HttpServletResponse response)
//        throws Exception {
//        System.out.println("##### /product/productRegistration  called #####");
//        }

//@RequestMapping(value = "/product/productStatus",
//        method = RequestMethod.PATCH,
//        produces = "application/json;charset=UTF-8")

    @PostMapping("/product")
    Product productInsert(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(method= RequestMethod.PATCH, path="/productupdate")
    public void productStatusChange(@RequestBody Product product) {
        System.out.println("INININININININININININININININININv");
        Product tmp = new Product();
        Optional<Product> productOtl = productRepository.findById(product.getId());
        tmp = productOtl.get();

        product.setProductName(tmp.getProductName());
        productRepository.save(product);
    }

 }
