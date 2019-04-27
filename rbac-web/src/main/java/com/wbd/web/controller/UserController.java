package com.wbd.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rbac.common.pojo.User;
import com.wbd.manager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;

	/**
	 * 传统的分页方式 分页核心的参数：页码（pageNum），每页显示的条数（pageSize）， 数据库的sql=select *from tb limit
	 * start,pagesize ,start从0开始
	 * 
	 * start = (pagenum-1)*pagesize 因为start从0开始，所以要减1
	 * 
	 */

	@RequestMapping("/index1")
	public String index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "2") Integer pageSize, Model model) {

		// 通过map进行传值

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", (pageNum - 1) * pageSize);
		map.put("size", pageSize);

		List<User> users = us.pageQueryData(map);

		model.addAttribute("users", users);

		// 当前页码
		model.addAttribute("pageNum", pageNum);

		// 总记录数
		int totalRecord = us.pageQueryCount(map);

		// 总页数
		int totalPage = 0;

		if (totalRecord % pageSize == 0) {

			totalPage = totalRecord / pageSize;

		} else {

			totalPage = totalRecord / pageSize + 1;

		}

		System.out.println("totalPage===" + totalPage);
		// 总页码
		model.addAttribute("totalPage", totalPage);

		// 需要把 总页数和当前页码传入到前台页码，还有总记录，暂时不把总记录数传入到前台页码
		return "user/index";
	}

}
