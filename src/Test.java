import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        boolean bo = true;
        while (bo) {

            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("输入的用户名：" + username);

            System.out.println("请输入密码");
            String password = sc.next();
            System.out.println("输入的密码是：" + password);

            //File file=new File("C:\\Users\\lenovo\\Desktop\\ConsoleShop\\src\\shuju.xlsx");
            InputStream Inuser = Class.forName("Test").getResourceAsStream("shuju.xlsx");
            InputStream Inproduct=Class.forName("Test").getResourceAsStream("/Products.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            ReadProductsExcel readProductExcel=new ReadProductsExcel();
            User users[] = readExcel.readExcel(Inuser);

            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println(("登录成功"));

                    /*
                    显示商品
                     */
                    Product products[]=readProductExcel.readExcel(Inproduct);
                    for(Product p:products){
                        System.out.print("\t"+p.getPID());
                        System.out.print("\t"+p.getPname());
                        System.out.print("\t"+p.getPcost());
                        System.out.println("\t"+p.getPdescri());
                    }
                    System.out.println("请输入商品的ID加入购物车");
                    int pid=sc.nextInt();
                    int count=0;
                    Product carts[]=new Product[3];
                    Inproduct=null;
                    Inproduct=Class.forName("Test").getResourceAsStream("/Products.xlsx");
                    Product product=readProductExcel.getProductByID(pid,Inproduct);
                    System.out.println(("要购买的商品的价格为：" + product.getPcost()));

                    if(product!=null)
                        carts[count++]=product;
                    System.out.println(("继续购物请按1"));
                    System.out.println(("查看购物车请按2"));
                    int choose=sc.nextInt();
                    /*
                    继续购物
                     */

                    if(choose==1){
                        Inproduct=null;
                        Inproduct=Class.forName("Test").getResourceAsStream("/Products.xlsx");
                        readProductExcel=new ReadProductsExcel();
                        products=readProductExcel.readExcel(Inproduct);
                        for(Product p:products){
                            System.out.print("\t"+p.getPID());
                            System.out.print("\t"+p.getPname());
                            System.out.print("\t"+p.getPcost());
                            System.out.println("\t"+p.getPdescri());
                        }

                        System.out.println(("输入商品ID加入购物车："));
                        pid=sc.nextInt();
                        Inproduct=null;
                        Inproduct=Class.forName("Test").getResourceAsStream("/Products.xlsx");
                        product=readProductExcel.getProductByID(pid,Inproduct);
                        System.out.println("要购买的商品的价格为：" + product.getPcost());

                        if(product!=null){

                            carts[count++]=product;
                        }


                    }
                    bo = false;
                    break;



                }else {
                    System.out.println("登录失败");

                }
            }
        }


    }
}
