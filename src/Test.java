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
            ReadProductExcel readProductExcel=new ReadProductExcel();
            User users[] = readExcel.readExcel(Inuser);

            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println(("登录成功"));
                    bo = false;
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
                    break;
                }else {
                    System.out.println("登录失败");

                }
            }
        }


    }
}
