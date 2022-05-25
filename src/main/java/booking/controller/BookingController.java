package booking.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import booking.model.Booking;
import booking.model.Hotel;
import booking.repository.BookingRepository;
import booking.repository.HotelRepository;
import booking.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class BookingController {
	@Autowired
	private HotelRepository hotelRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	
//	@GetMapping
//	public String getMainPage() {
//		return "room/room-list";
//	}
	
	@GetMapping("/booking/form")
	public String getBookingForm(Booking booking, Model model) {
		model.addAttribute("listHotel", hotelRepo.findAll());
		model.addAttribute("listRoom", roomRepo.findAll());
		return "booking/booking-add";
	}
	
	@GetMapping("/booking/update")
	public String getUpdateForm(@RequestParam("id")long id , Model model) {
		model.addAttribute("booking", bookingRepo.findById(id));
		return "booking/booking-update";
	}
	
	@GetMapping("/booking/delete")
	public String getDeleteForm(@RequestParam("id")long id , Model model) {
		model.addAttribute("booking", bookingRepo.findById(id).get());
		return "booking/booking-delete";
	}
	
	@GetMapping("/booking/all")
	public String getAllBooking(Model model) {
		model.addAttribute("list", bookingRepo.findAll());
		return "booking/booking-list";
	}
	
	
	@PostMapping("/booking/add")
	//public String addBooking(@RequestParam("checkin")String checkin,@RequestParam("checkout")String checkout,Booking booking) throws ParseException {
	public String addBooking(Booking booking) {
//		log.info("booking controller");
//		log.info(booking.getCheckin()+"");
//		log.info(booking.getCheckout()+"");
		bookingRepo.save(booking);
		return "redirect:/booking/all";
	}
	
	@PostMapping("/booking/update")
	public String updateBooking(Booking booking) {
		bookingRepo.save(booking);
		return "redirect:/booking/all";
	}
	
	@PostMapping("/booking/delete")
	public String deleteBooking(@RequestParam("id")long id) {
		bookingRepo.deleteById(id);
		return "redirect:/booking/all";
	}
}
