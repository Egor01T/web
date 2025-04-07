package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.User;
import com.example.services.dto.SubscribeDTO;
import com.example.services.impl.PostServiceImpl;
import com.example.services.impl.SubscribeServiceImpl;
import com.example.views.SubscribeRowViewModel;

@Controller
@RequestMapping("/subscriptions")
public class SubscribeController {

    @Autowired
    private SubscribeServiceImpl subscribeService;
    @Autowired
    private PostServiceImpl postService;

    @GetMapping
    public String subsList(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        Model model,
        Principal principal
    ){
        Page<SubscribeRowViewModel> subs = subscribeService.getSubs(principal.getName(),PageRequest.of(page, size));
        model.addAttribute("subscriptions",subs);
        return "subscribes_list";
    }

    @PostMapping("/delete/{id}")
    public String deleteSubscription(
        @PathVariable int id,
        RedirectAttributes redirectAttributes,
        Principal principal
    ) {
        if(!subscribeService.isUsersSub(id, principal.getName())){
            redirectAttributes.addFlashAttribute("errorMessage", "Error unsubscribing");
            return "redirect:/subscriptions";
        }
        try {
            subscribeService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully unsubscribed");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error unsubscribing");
        }
        return "redirect:/subscriptions";
    }

    @PostMapping("/subscribe/{id}")
    public String subscribe(
        @PathVariable int id,
        RedirectAttributes redirectAttributes,
        Principal principal
    ) {
        User author = postService.getUserByPostId(id);
        if(subscribeService.isSubExist(author.getUsername(), principal.getName())){
            redirectAttributes.addFlashAttribute("errorMessage", "Error subscribing");
            return "redirect:/subscriptions";
        }
        SubscribeDTO dto = new SubscribeDTO();
        dto.setUser(author.getUsername());
        dto.setSubscribedUser(principal.getName());
        try {
            subscribeService.create(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully subscribed");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error subscribing");
        }
        return "redirect:/post/" + id;
    }
}
