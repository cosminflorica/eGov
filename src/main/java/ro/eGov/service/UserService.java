package ro.eGov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.eGov.dto.UserDTO;
import ro.eGov.dto.UserLogDTO;
import ro.eGov.entities.User;
import ro.eGov.repositories.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Calendar;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserDTO verifyUser(String email, String password){
        User user=userRepository.findUserByEmail(email);
        if(user.getPassword().equals(password)){
            System.out.println("User authenticated !!");
            return new UserDTO(user);}
            else{
            return null;
        }
    }

    public void createXML(UserLogDTO userLogDTO){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Formular");
            doc.appendChild(rootElement);

            Element firstElement = doc.createElement( "Nume" );
            firstElement.appendChild( doc.createTextNode( userLogDTO.getNume() ) );
            rootElement.appendChild( firstElement );

            Element secondElement = doc.createElement( "Prenume" );
            secondElement.appendChild( doc.createTextNode( userLogDTO.getPrenume() ) );
            rootElement.appendChild( secondElement );

            Element thirdElement = doc.createElement( "Email" );
            thirdElement.appendChild( doc.createTextNode( userLogDTO.getEmail() ) );
            rootElement.appendChild( thirdElement );

            Element forthElement = doc.createElement( "Judet" );
            forthElement.appendChild( doc.createTextNode( userLogDTO.getJudet() ) );
            rootElement.appendChild( forthElement );
/*
            Element fifthElement = doc.createElement( "Capacitate" );
            fifthElement.appendChild( doc.createTextNode( userLogDTO.getCapacitate().toString() ) );
            rootElement.appendChild( fifthElement );
*/
            Element sixthElement = doc.createElement( "Valoare" );
            sixthElement.appendChild( doc.createTextNode(userLogDTO.getValoare()) );
            rootElement.appendChild( sixthElement );

            Element seventhElement = doc.createElement( "Data" );
            seventhElement.appendChild( doc.createTextNode( Calendar.getInstance().getTime().toString()) );
            rootElement.appendChild( seventhElement );





            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
                Date date = new Date();

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Result output = new StreamResult(new File("logs/formular"+formatter.format(date)+".xml"));
                Source input = new DOMSource(doc);

                transformer.transform(input, output);
                System.out.println("Log file created...");

            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
