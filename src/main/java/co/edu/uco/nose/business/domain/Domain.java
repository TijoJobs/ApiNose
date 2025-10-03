package co.edu.uco.nose.business.domain;
import co.edu.uco.nose.crosscuting.helpers.UUIDHelper;

import java.util.UUID;
 class Domain {
     private UUID id;
     protected Domain(final UUID id) {
         this.id = id;
     }

     public UUID getId() {
         return id;
     }

     public void setId(UUID id) {
         this.id = UUIDHelper.getUUIDHelper().getDefault(id);

     }

     public static void main(String[] args) {
         System.out.println(UUID.randomUUID());
     }
 }
