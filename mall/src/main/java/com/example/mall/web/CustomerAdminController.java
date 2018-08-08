package com.example.mall.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Customer;
import com.example.mall.service.CustomerAdminService;
import com.example.mall.utils.Page;

@Controller
@RequestMapping("/admin")
public class CustomerAdminController {
	
	@Autowired
	private CustomerAdminService customerAdminService;
	
	/**
	 * 分页查询用户列表
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/query/user/{id}",method = RequestMethod.GET)
	public String queryAccountByPage(Model model,@PathVariable("id") Integer id) {
		List<Customer> accountInfos = customerAdminService.queryAccountList();
		Page page = new Page(accountInfos.size(), id);
		
		List<Customer> userList = customerAdminService.queryAccountByPage(page.getStart(), page.getPageNum());
		model.addAttribute("userList", userList);
		List<Integer> amountPage = new ArrayList<>();
		for(int i=1;i<=page.getAllPage();i++)
			amountPage.add(i);
		model.addAttribute("amountPage", amountPage);
		return "customer_admin";
	}
	
	/**
	 * 按名字来搜索用户
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/query/user/name",method = RequestMethod.POST)
	public String queryAccountByName(Model model,@RequestParam(value="userName") String name) {
		List<Customer> accountInfos = customerAdminService.queryAccountByName(name);
		model.addAttribute("userList", accountInfos);
		model.addAttribute("name", name);
		return "customer_admin";
	}
	
	/**
	 * 查询用户的黑名单
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/query/user/blacklist",method=RequestMethod.GET)
	public String queryUserBlackList(Model model) {
		 
		List<Customer> accountInfos = customerAdminService.queryBlackList();
		model.addAttribute("userList", accountInfos);
		return "customer_blacklist_admin";
	}
	
	/**
	 * 根据用户id将用户加入黑名单
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/add/user/blacklist/{id}",method=RequestMethod.GET)
	public String addUserBlackList(Model model,@PathVariable("id") Integer id) {
		customerAdminService.addUserBlackList(id);
		return "redirect:/admin/query/user/1";
	}
	
	/**
	 * 根据用户id，将用户移除黑名单
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/remove/user/blacklist/{userId}",method=RequestMethod.GET)
	public String removeUserBlackList(@PathVariable("userId") Integer userId) {
		customerAdminService.removeUserBlackList(userId);
		return "redirect:/admin/query/user/blacklist";
	}
	
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/delete/user/{userId}",method=RequestMethod.GET)
	public String deleteUserById(@PathVariable("userId") Integer userId) {
		customerAdminService.deleteCustomerById(userId);
		return "redirect:/admin/query/user/1";
	}
}
