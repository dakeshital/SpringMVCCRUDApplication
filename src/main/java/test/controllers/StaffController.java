package test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.beans.Staff;
import test.dao.StaffDao;

@Controller
public class StaffController {

	@Autowired
	StaffDao sdao;

	@RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("s1") Staff s1) {
		sdao.saveStaffData(s1);
		return "redirect:/viewStaff";
	}

	@RequestMapping("/viewStaff")
	public String getAllData(Model m) {
		List<Staff> list = sdao.getStaffData();
		m.addAttribute("list", list);
		return "viewStaff";
	}

	@RequestMapping(value = "/deleteStaff/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		sdao.delete(id);
		return "redirect:/viewStaff";
	}

	@RequestMapping(value = "/editStaff/{id}")
	public String editStaff(@PathVariable int id, Model model) {
		Staff staff = sdao.getStaffById(id);
		model.addAttribute("staff", staff);
		return "editStaff"; 
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editStaffData(@ModelAttribute("staf") Staff staff) {
		sdao.updateData(staff);
		return "redirect:/viewStaff"; // Redirect to viewStaff after updating
	}

}
