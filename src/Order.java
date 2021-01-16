import java.util.Date;

/**
 * @author 13222
 * @Description:
 * @date 2021年01月16日 14:06
 */
public class Order {
    private User user;
    private Product products[];
    private int productNum;
    private float totalprice;
    private float totalpat;

    private Date dateorder;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public float getTotalpat() {
        return totalpat;
    }

    public void setTotalpat(float totalpat) {
        this.totalpat = totalpat;
    }

    public Date getDateorder() {
        return dateorder;
    }

    public void setDateorder(Date dateorder) {
        this.dateorder = dateorder;
    }
}
