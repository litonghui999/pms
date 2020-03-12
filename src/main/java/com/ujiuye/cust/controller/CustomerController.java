package com.ujiuye.cust.controller;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public  List<Customer> getCustomerJsonList(){
         Map<String,Object> map = new HashMap<String,Object>();
        List<Customer> list= customerService.getCustomerList();
        return list;
        
    }

    @RequestMapping(value="/search",method=RequestMethod.GET)
    public ModelAndView search(int cid,String keyword,int orderby){
        ModelAndView mv = new ModelAndView("customer");
        List<Customer> list = customerService.search(cid,keyword,orderby);
        mv.addObject("list",list);
        mv.addObject("keyword",keyword);
        return mv;

    }

    @RequestMapping("/del/{ids}")
    @ResponseBody
    public Map<String,Object> batchDelete(@PathVariable("ids") String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean result=  customerService.batchDelete(ids);
        if(result){
            map.put("statusCode",200);
            map.put("message","删除成功");
        }else{
            map.put("statusCode",500);
            map.put("message","删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String edit(Customer customer){
        customerService.updateCustomerInfo(customer);
        return "redirect:/cust/list";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer cid, Map<String,Object> map){
        Customer customer = customerService.getCustomerInfoById(cid);
        map.put("customer",customer);
        return "customer-edit";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String getCustomerInfo(@PathVariable("id") Integer cid, Map<String,Object> map){
        Customer customer = customerService.getCustomerInfoById(cid);
        map.put("customer",customer);
        return "customer-look";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getCustomerList(){
        List<Customer> list= customerService.getCustomerList();
        ModelAndView mv = new ModelAndView("customer");
        mv.addObject("list",list);
        return mv;
    }

    /**
     * 保存客户信息
     * @param customer:实体类对象
     * @return: customer页面
     */
    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Customer customer){
        customerService.saveInfo(customer);
        return "redirect:/cust/list";
    }
}
