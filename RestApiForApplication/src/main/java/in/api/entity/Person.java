package in.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Person 
{
      Integer aadhaarCard;
      String name;
      String phoneNumber;
      String start;
      String end;
}
