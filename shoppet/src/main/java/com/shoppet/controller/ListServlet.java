package com.shoppet.controller;


import com.shoppet.dao.ProductDAO;
import com.shoppet.model.Item;
import com.shoppet.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = "")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;


    public void init() {
        productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
//                case "search":
//                    searchByName(req,resp);
//                    break;
//                case "show":
//                    showList(req,resp);
//                    break;
//                case "s":
//                    h(req,resp);
//                    break;
//                case "info":
//                    showInfoPet(req,resp);
//                    break;
//                case "infop":
//                    showInfoP(req,resp);
//                    break;
//                case "infos":
//                    showInfoS(req,resp);
//                    break;
                case "":
                    show(req,resp);
                    break;
//                case "1":
//                    showListpet(req,resp);
//                    break;
//                case "2":
//                    showListp(req,resp);
//                    break;
//                case "3":
//                    showLists(req,resp);
//                    break;
//                case "buy":
//                    doGet_buy(req, resp);
//                    break;
//                case "remove":
//                    doGet_Remove(req, resp);
//                    break;
//                case "buyp":
//                    doGet_buyp(req, resp);
//                    break;
//                case "removep":
//                    doGet_Remove1(req, resp);
//                    break;
//                case "buys":
//                    doGet_buys(req, resp);
//                    break;
//                case "removes":
//                    doGet_Remove2(req, resp);
//                    break;
                case "get":
                    doGet_DisplayCart(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    private void showInfoPet(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product existing = productDAO.s(id);
//        request.setAttribute("pet", existing);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("chitiet.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showInfoP(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product existing = productDAO.selectP(id);
//        request.setAttribute("product", existing);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("chitietproduct.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showInfoS(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Services existing = serviceDAO.selectS(id);
//        request.setAttribute("product", existing);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("chitietdichvu.jsp");
//        dispatcher.forward(request, response);
//    }

//    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//
//        String key = request.getParameter("key");
//        List<Product> productList = productDAO.findProduct(key);
//        request.setAttribute("productList", productList);
//        List<Pet> petList = petDAO.findP(key);
//        request.setAttribute("petList",petList);
//        List<Services> servicesList = serviceDAO.findS(key);
//        request.setAttribute("servicesList", servicesList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("danhmucsanpham/search.jsp");
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = productDAO.selectAllPro();
        request.setAttribute("listP", listP);
        List<Product> listPet = productDAO.selectAllPet();
        request.setAttribute("listPe", listPet);
        List<Product> listS = productDAO.selectAllService();
        request.setAttribute("listS", listS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pet.jsp");
        dispatcher.forward(request, response);
    }

    private void show(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = productDAO.selectAllProduct();
        request.setAttribute("listP", listP);
        List<Product> listPet = productDAO.selectAllPet();
        request.setAttribute("listPe", listPet);
        List<Product> listS = productDAO.selectAllService();
        request.setAttribute("listS", listS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
//    private void h(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//        dispatcher.forward(request, response);
//    }
//    private void showListpet(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmucsanpham/pets/pet.jsp");
//        dispatcher.forward(request, response);
//    }
//    private void showListp(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmucsanpham/phukien/phukien.jsp");
//        dispatcher.forward(request, response);
//    }
//    private void showLists(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmucsanpham/dichvu/dichvu.jsp");
//        dispatcher.forward(request, response);
//    }

    //    private void doGet_buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDAO ProductDAO = new ProductDAO();
//        HttpSession session = request.getSession();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Item item;
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList<>();
//            Product product = ProductDAO.selectP(id);
//            item = new Item(product,1);
//            cart.add(item);
//            /*cart.add(new Item(product, 1));*/
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExisting(id, cart);
//            if (index == -1) {
//                Product product = ProductDAO.selectP(id);
//                item = new Item(product,1);
//                cart.add(item);
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
////        response.sendRedirect("index.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        int id = Integer.parseInt(request.getParameter("id"));
//        int index = isExisting(id, cart);
//        cart.remove(index);
//        session.setAttribute("cart", cart);
//        response.sendRedirect("cart");
//    }
//
//    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("cart/index.jsp").forward(request, response);
//    }
//
//    private int isExisting(int id, List<Item> cart) {
//        for (int i = 0; i < cart.size(); i++) {
//            if (cart.get(i).getProduct().getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    private void doGet_buydd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PetDAO petDAO = new PetDAO();
//        ProductDAOO ProductDAO = new ProductDAOO();
//        ServiceDAO serviceDAO = new ServiceDAO();
//        HttpSession session = request.getSession();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Item item,item1,item2;
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList<>();
//            Pet pet = petDAO.selectPet(id);
//            Product product = ProductDAO.selectP(id);
//            Services services = serviceDAO.selectS(id);
//            item = new Item(product,1);
//            item1 = new Item(pet,1);
//            item2 = new Item(services,1);
//            cart.add(item);
//            cart.add(item1);
//            cart.add(item2);
//            /*cart.add(new Item(product, 1));*/
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExisting(id, cart);
//            int index1 = isExisting(id, cart);
//            int index2 = isExisting(id, cart);
//            if (index == -1) {
//                Pet pet = petDAO.selectPet(id);
//                Product product = ProductDAO.selectP(id);
//                Services services = serviceDAO.selectS(id);
//                item = new Item(product,1);
//                item1 = new Item(pet,1);
//                item2 = new Item(services,1);
//                cart.add(item);
//                cart.add(item1);
//                cart.add(item2);
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
////        response.sendRedirect("index.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void doGet_buyp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PetDAO petDAO = new PetDAO();
//        HttpSession session = request.getSession();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Item item;
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList<>();
//            Pet pet = petDAO.selectPet(id);
//            item = new Item(pet,1);
//            cart.add(item);
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExistingp(id, cart);
//            if (index == -1) {
//                Pet pet = petDAO.selectPet(id);
//                item = new Item(pet,1);
//                cart.add(item);
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void doGet_buys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServiceDAO serviceDAO = new ServiceDAO();
//        HttpSession session = request.getSession();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Item item;
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList<>();
//            Services services = serviceDAO.selectS(id);
//            item = new Item(services,1);
//            cart.add(item);
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExistings(id, cart);
//            if (index == -1) {
//                Services services = serviceDAO.selectS(id);
//                item = new Item(services,1);
//                cart.add(item);
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void doGet_buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDAOO ProductDAO = new ProductDAOO();
//        HttpSession session = request.getSession();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Item item;
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList<>();
//            Product product = ProductDAO.selectP(id);
//            item = new Item(product,1);
//            cart.add(item);
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExisting(id, cart);
//            if (index == -1) {
//                Product product = ProductDAO.selectP(id);
//                item = new Item(product,1);
//                cart.add(item);
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//        List<Product> listP = productDAO.selectAllP();
//        request.setAttribute("listP", listP);
//        List<Pet> listPet = petDAO.selectAllPet();
//        request.setAttribute("listPet", listPet);
//        List<Services> listS = serviceDAO.selectAllS();
//        request.setAttribute("listS", listS);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }


    private void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("id"));
        int index = isExisting(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }
//    private void doGet_Remove1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        int id = Integer.parseInt(request.getParameter("id"));
//        int index = isExistingp(id, cart);
//        cart.remove(index);
//        session.setAttribute("cart", cart);
//        response.sendRedirect("cart");
//    }
//    private void doGet_Remove2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        int id = Integer.parseInt(request.getParameter("id"));
//        int index = isExistings(id, cart);
//        cart.remove(index);
//        session.setAttribute("cart", cart);
//        response.sendRedirect("cart");
//    }

    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart/index.jsp").forward(request, response);
    }

    private int isExisting(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
