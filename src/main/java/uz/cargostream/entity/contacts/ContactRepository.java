package uz.cargostream.entity.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.contacts.projection.ContactProjection;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    @Query(nativeQuery = true,
            value = "select cast(c.id as varchar) as contactId,\n" +
                    "       c.email               as email,\n" +
                    "       c.location            as location,\n" +
                    "       p.original_name       as orginalname,\n" +
                    "       p.url_name            as urlName\n" +
                    "from contacts c\n" +
                    "         join photos p on c.photo_id = p.id\n")
    List<ContactProjection> getAllContacts();


    @Query(nativeQuery = true,
            value = "select cn.numbers\n" +
                    "from contacts_numbers cn\n" +
                    "where cn.contacts_id = :contactId")
    List<String> getNumbersByContactId(UUID contactId);
}
