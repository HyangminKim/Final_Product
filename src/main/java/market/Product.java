package market;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import org.springframework.support.TransactionSyncronizationAdapter;
import org.springframework.support.TransactionSyncronizationManager;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String productName;
    private String productStatus;

    @PostPersist
    public void onPostPersist(){
        ProductRegistered productRegistered = new ProductRegistered();
        BeanUtils.copyProperties(this, productRegistered);
        productRegistered.publish();
try {
 Thread.currentThread().sleep((long) (400+ Math.random() * 220));
}catch (InterruptedExection e){
e.printStackTrace();
}

    }

    @PostUpdate
    public void onPostUpdate(){
        ProductStatusChanged productStatusChanged = new ProductStatusChanged();
        BeanUtils.copyProperties(this, productStatusChanged);
        productStatusChanged.publish();


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }




}
