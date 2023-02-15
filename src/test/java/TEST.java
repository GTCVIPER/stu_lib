import com.gtc.DAO.AccountDAO;
import com.gtc.DAO.BookDAO;
import com.gtc.DAO.Impl.AccountDAOImpl;
import com.gtc.DAO.Impl.BookDAOImpl;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.gtc.controller.AccountController;
import com.gtc.entity.Account;
import com.gtc.entity.Books;
import org.junit.Test;
import com.gtc.service.AccountService;
import com.gtc.service.BooksService;
import com.gtc.service.Impl.AccountServiceImpl;
import com.gtc.service.Impl.BookServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) throws SQLException {
        AccountDAO accountDAO = new AccountDAOImpl();
        List<Account> accounts = accountDAO.selectALLAccount();
        for (Account acc: accounts) {
            System.out.println(acc);
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Test
    public void asd() throws SQLException {
        AccountDAO accountDAO = new AccountDAOImpl();
        System.out.println(accountDAO.selectAccountById(3));
    }

    @Test
    public void asdx() throws SQLException {
        BookDAO bookDAO = new BookDAOImpl();
        List<Books> books = bookDAO.selectALLBooks();
        for (Books boo: books) {
            System.out.println(boo);
        }
    }

    @Test
    public void asdf() throws SQLException {
        BookDAO bookDAO = new BookDAOImpl();
        System.out.println(bookDAO.selectBookById(3));
    }

    @Test
    public void asddf() throws SQLException {
      List<Entity> findAll = Db.use().findAll("t_account");
        System.out.println(findAll);
    }


    @Test
    public void asgf() throws SQLException{
        List<Entity> list = Db.use().findAll(Entity.create("t_account").set("id",3));
        System.out.println(list);
    }

    @Test
    public void sdf(){
        AccountService accountService = new AccountServiceImpl();
        List<Account> allAccount = accountService.findALLAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void sddf(){
        AccountService accountService = new AccountServiceImpl();
        List<Account> allAccount = accountService.findALLAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void sdd(){
        Books books = new Books(null, "赵文浩自传", 34, "赵文浩");
        BooksService booksService = new BookServiceImpl();
        booksService.saveBook(books);
        new Scanner(System.in).nextLine();
    }

    @Test
    public void sadd(){
        Books books = new Books(14, "赵文regf浩自传", 34, "赵文浩");
        BooksService booksService = new BookServiceImpl();
        booksService.modifyBookById(books);
        new Scanner(System.in).nextLine();
    }

    @Test
    public void sad(){

        final Account account = new Account();
        account.setUsername("顾天辰");
        account.setPassword("gtc123456");
        System.out.println(new AccountController().register(account));

    }

    @Test
    public void svd(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pass = scanner1.nextLine();
        AccountController controller = new AccountController();
        boolean login = controller.login(name,pass);
        if (login) {
            System.out.println("Access Granted...");
        } else {
            System.out.println("Login Failed...");
        }
    }

    @Test
    public void sbd(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名ID(1)：");
        int id_a = scanner.nextInt();
        System.out.println("请输入用户名ID(2)：");
        int id_b = scanner.nextInt();
        System.out.println("请输入转账金额：");
        double money = scanner.nextDouble();
        AccountController controller = new AccountController();
        boolean flag = controller.transBalance(id_a,id_b,money);
        new Scanner(System.in).nextLine();
        if (flag) {
            System.out.println("SUCCESS ...");
        } else {
            System.out.println("Failed...");
        }
    }
    @Test
    public void grf(){
        String b = "";
        System.out.println(b.isEmpty());
    }
}
