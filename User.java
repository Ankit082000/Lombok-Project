package com.springboot.JournalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

   @Id
    private ObjectId id;

   @Indexed(unique = true)           //index kar rahi hai aur ye automatically create nhi hoga ise application properties mai jaake karana hoga
   @NonNull
    private String username;

   @NonNull
    private String password;


   @DBRef                                                               //ye refrence create kar rahi h user ka journal entry ke saath
    private List<JournalEntry> journalEntries =new ArrayList<>();      //isme journal entries user ke saath link ho gayi hai
}
