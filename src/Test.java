import java.io.InputStream;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static Product carts[] = new Product[3];
    static int count=0;

    public static void main(String[] args) throws ClassNotFoundException {


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
            InputStream Inproduct = Class.forName("Test").getResourceAsStream("/Products.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            ReadProductsExcel readProductExcel = new ReadProductsExcel();
            User users[] = readExcel.readExcel(Inuser);

            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println(("登录成功"));

                    /*
                    显示商品
                     */

                    Product products[] = readProductExcel.readExcel(Inproduct);
                    shopping(Inproduct);
                    boolean ba = true;
                    while (ba) {
                        System.out.println(("继续购物请按1"));
                        System.out.println(("查看购物车请按2"));
                        System.out.println("退出请按3");
                        int choose = sc.nextInt();
                    /*
                    继续购物
                     */

                        if (choose == 1) {

                        shopping(Inproduct);

                        }if (choose == 2) {
                            viewCarts();


                        }if (choose == 3)
                            ba = false;
                    }
                    bo = false;
                    break;


                } else {
                    System.out.println("登录失败");

                }
            }
        }


    }
    public static void viewCarts(){
        for (Product p : carts) {

            if (p!= null) {

                System.out.print("\t" + p.getPID());
                System.out.print("\t" + p.getPname());
                System.out.print("\t" + p.getPcost());
                System.out.println("\t" + p.getPdescri());

            }
        }

    }


    public static void shopping(InputStream in) throws ClassNotFoundException {

        in = null;
        in = Class.forName("Test").getResourceAsStream("/Products.xlsx");
        ReadProductsExcel readProductExcel = new ReadProductsExcel();
        Product products[] = readProductExcel.readExcel(in);
        for (Product p : products) {

            System.out.print("\t" + p.getPID());
            System.out.print("\t" + p.getPname());
            System.out.print("\t" + p.getPcost());
            System.out.println("\t" + p.getPdescri());
        }

        System.out.println(("输入商品ID加入购物车："));
        int pid = sc.nextInt();

        in = null;
        in = Class.forName("Test").getResourceAsStream("/Products.xlsx");
        Product product = readProductExcel.getProductByID(pid, in);
        System.out.println("要购买的商品的价格为：" + product.getPcost());

        if (product != null) {

            carts[count++] = product;

        }
    }

}
