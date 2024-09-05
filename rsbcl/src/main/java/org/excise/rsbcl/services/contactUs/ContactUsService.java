package org.excise.rsbcl.services.contactUs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.contactUs.ContactUsDAO;
import org.excise.rsbcl.model.contactUs.ContactUs;
import org.excise.rsbcl.repository.contactus.ContactUsRepo;
import org.excise.rsbcl.services.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsService {
    @Autowired
    private final ContactUsRepo contactUsRepo;

    @Autowired
    private final CloudinaryService cloudinaryService;

    public ContactUsService(ContactUsRepo contactUsRepo, CloudinaryService cloudinaryService) {
        this.contactUsRepo = contactUsRepo;
        this.cloudinaryService = cloudinaryService;
    }

    public Response<List<ContactUs>> getAllContactUs() {
        try {
            List<ContactUs> contacts = contactUsRepo.findAll();
            if (contacts.isEmpty()) return new Response<>("Error404", "Contacts not found", null);
            return new Response<>("Success", "Contacts are found", contacts);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<ContactUs> getContactUsById(ObjectId id) {
        try {
            ContactUs contactUs = contactUsRepo.findById(id).orElse(null);
            if (contactUs != null) return new Response<>("Success", "Contact found", contactUs);
            return new Response<>("Error404", "Contact are not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<ContactUs> saveContactUs(ContactUsDAO contactUsDAO) {
        try {
            ContactUs oldContact = contactUsRepo.findByBranch(contactUsDAO.getBranch()).orElse(null);
            if (oldContact != null) {
                String imageUrl = cloudinaryService.uploadFileToCloudinary(contactUsDAO.getImage());
                oldContact.setContactNo(contactUsDAO.getContactNo());
                oldContact.setBranch(contactUsDAO.getBranch());
                oldContact.setAddress(contactUsDAO.getAddress());
                oldContact.setEmail(contactUsDAO.getEmail());
                oldContact.setStatus(contactUsDAO.isStatus());
                oldContact.setFaxNo(contactUsDAO.getFaxNo());
                oldContact.setImageLink(imageUrl);
                oldContact.setLastUpdate(LocalDateTime.now());
                ContactUs newContactUs = contactUsRepo.save(oldContact);
                return new Response<>("Success", "Contact saved successfully", newContactUs);
            } else {
                return new Response<>("Error208", "This Contact already exists !!", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<List<ContactUs>> saveContactUses(List<ContactUs> contactUsList) {
        try {
            List<ContactUs> savedContacts = contactUsRepo.saveAll(contactUsList);
            return new Response<>("Success", "Contact uses saved successfully", savedContacts);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<ContactUs> updateContactUs(ObjectId id, ContactUs contactUs) {
        try {
            ContactUs oldContactUs = contactUsRepo.findById(id).orElse(null);
            if (oldContactUs != null) {
                oldContactUs.setLastUpdate(LocalDateTime.now());
                oldContactUs.setBranch((contactUs.getBranch() != null && !contactUs.getBranch().equals(oldContactUs.getBranch())) ? contactUs.getBranch() : oldContactUs.getBranch());
                oldContactUs.setAddress((contactUs.getAddress() != null && !contactUs.getAddress().equals(oldContactUs.getAddress())) ? contactUs.getAddress() : oldContactUs.getAddress());
                oldContactUs.setContactNo((contactUs.getContactNo() != null && !contactUs.getContactNo().equals(oldContactUs.getContactNo())) ? contactUs.getContactNo() : oldContactUs.getContactNo());
                oldContactUs.setFaxNo((contactUs.getFaxNo() != null && !contactUs.getFaxNo().equals(oldContactUs.getFaxNo())) ? contactUs.getFaxNo() : oldContactUs.getFaxNo());
                oldContactUs.setEmail((contactUs.getEmail() != null && !contactUs.getEmail().equals(oldContactUs.getEmail())) ? contactUs.getEmail() : oldContactUs.getEmail());
                oldContactUs.setImageLink((contactUs.getImageLink() != null && !contactUs.getImageLink().equals(oldContactUs.getImageLink())) ? contactUs.getImageLink() : oldContactUs.getImageLink());
                oldContactUs.setStatus(contactUs.isStatus());
                return new Response<>("Success", "Contact us updated successfully", oldContactUs);
            } else {
                return new Response<>("Error404", "Contact us not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteContactUs(ObjectId id) {
        try {
            Optional<ContactUs> oldContactUs = contactUsRepo.findById(id);
            if (oldContactUs.isPresent()) {
                contactUsRepo.deleteById(id);
                return new Response<>("Success", "Contact us deleted successfully", null);
            } else {
                return new Response<>("Error404", "Contact us not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
