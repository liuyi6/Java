package com.example.mall.service.impl;

import com.example.mall.dao.ProductSellDao;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.Product;
import com.example.mall.entity.ProductResult;
import com.example.mall.entity.ProductResult2;
import com.example.mall.entity.SellOrder;
import com.example.mall.entity.Shop;
import com.example.mall.service.ProductSellService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
@Service
public class ProductSellServiceIMP implements ProductSellService{
	@Resource
	private ProductSellDao dao;

	@Override
	public ProductResult2 updateProduct(Integer productId, String productName, String type, Double price, Integer kunumber, String path, String desc) {
		ProductResult2 result=new ProductResult2();
		Product pro=new Product();
		pro.setProductId(productId);
		pro.setProductName(productName);
		pro.setShopCategoryName(type);
		pro.setProductPrice(price);
		pro.setProductCount(kunumber);
		pro.setImgAddr(path);
		pro.setProductDesc(desc);
		dao.updateProduct(pro);
		result.setData(pro);
		return result;
	}

    @Override
    public ProductResult2 findByShopId(String shopId) {
        ProductResult2 result=new ProductResult2();
        String name=dao.findByShopId(shopId);
        result.setData(name);
        return result;
    }

    @Override
    public ProductResult2 findByProductId(String productId) {
        ProductResult2 result=new ProductResult2();

        Product pro=dao.findByProductId(productId);

        result.setData(pro);
        return result;
    }

    @Override
	public ProductResult addProduct(String productName, String shopCategoryName, int productCount, String imgAddr,int shopId,double price) {
		ProductResult result=new ProductResult();
		Product pro=new Product();
		pro.setProductName(productName);
		pro.setShopCategoryName(shopCategoryName);
		pro.setProductCount(productCount);
		pro.setImgAddr(imgAddr);
		pro.setShopId(shopId);
		pro.setProductPrice(price);

		dao.addProduct(pro);
		result.setKunumber(productCount);
		result.setName(productName);
		result.setPath(imgAddr);
		result.setType(shopCategoryName);
		result.setPrice(price);
		result.setShopId(shopId);
		return result;
	}

    @Override
    public ProductResult2 deleteProduct(Integer ProductId) {
        ProductResult2 result=new ProductResult2();
	    dao.deleteProduct(ProductId);
        result.setData(0);
	    return result;
    }

    @Override
	public ProductResult2 showProduct(int shopId) {
		ProductResult2 result=new ProductResult2();
		
		
		List<Product>  pro=dao.showProduct(shopId);
		int num=pro.size();
		result.setData(pro);
		result.setNum(num);
		
		return result;
	}

    @Override
    public ProductResult2 login(String account,String password) {//检查登录
        ProductResult2 result=new ProductResult2();
        Shop shop=dao.login(account);
        if(account==null||password==null){
            result.setData("a3");
            return  result;
        }
        if(shop==null){
            result.setData("a0");
            return  result;
        }else if(!shop.getPassword().equals(password)){
            result.setData("a1");
            return result;
        }else {
        	int num=shop.getEnableStatus();
        	if(num==0) {
        		result.setData("a4");
        	}else if (num==1) {
        		 result.setData(shop.getShopId());
			}else {
				result.setData("a5");
			}
           
        }
        return result;
    }

    @Override
    public ProductResult2 findShopId(String account) {
        ProductResult2 result=new ProductResult2();
        String shopId=dao.findShopId(account);
        result.setData(shopId);
        return result;
    }

    @Override
    public ProductResult2 save(String userName, String password, String shopName, String shopAddres, String shopPhone, String shopEmail) {
        ProductResult2 result=new ProductResult2();
        Shop shop2=dao.findByAccount(userName);
        if(shop2!=null){
            result.setData("0");
            return  result;

        }
        Shop shop1=dao.findByShopName(shopName);
        if (shop1!=null){
            result.setData("1");
            return  result;
        }

        Shop shop=new Shop();
        shop.setUserName(userName);
        shop.setPassword(password);
        shop.setShopName(shopName);
        shop.setShopAddress(shopAddres);
        shop.setShopEmail(shopEmail);
        shop.setShopPhone(shopPhone);
        dao.save(shop);
        result.setData("2");

	    return result;
    }

    @Override
	public ProductResult2 pageProduct(int shopId, int num) {
		ProductResult2 result=new ProductResult2();
		
		
		List<Product>  pro=dao.pageProduct(shopId,num);
		result.setData(pro);
		result.setNum(num);
		
		return result;
	}

    @Override
    public ProductResult2 selectOrders(Date start, Date end, Integer shopId) {
        ProductResult2 result=new ProductResult2();

        List<SellOrder>  or=dao.selectOrders(start,end,shopId);
        result.setData(or);
        return result;
    }

    @Override
    public ProductResult2 selecctCustomer(String detailId) {
        ProductResult2 result=new ProductResult2();
        OrdersDetail od=dao.selecctCustomer(detailId);
        result.setData(od);
        return result;
    }

}
