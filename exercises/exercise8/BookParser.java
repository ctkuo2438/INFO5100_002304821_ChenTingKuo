package exercise8;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookParser {

    public static void main(String[] args) {
        try {
            // Parse and print XML
            System.out.println("Parsing XML...");
            Document xmlDoc = parseXML("/Users/zhenting/INFO5100_002304821_ChenTingKuo/exercises/exercise8/books.xml");
            printXML(xmlDoc);

            // Parse and print JSON
            System.out.println("\nParsing JSON...");
            JSONObject jsonDoc = parseJSON("/Users/zhenting/INFO5100_002304821_ChenTingKuo/exercises/exercise8/books.json");
            printJSON(jsonDoc);

            // Add a new book to XML
            System.out.println("\nAdding a new book to XML...");
            addBookToXML(xmlDoc);
            printXML(xmlDoc);

            // Add a new book to JSON
            System.out.println("\nAdding a new book to JSON...");
            addBookToJSON(jsonDoc);
            printJSON(jsonDoc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Parse XML file
    private static Document parseXML(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(filePath));
    }

    // Print XML content
    private static void printXML(Document doc) {
        doc.getDocumentElement().normalize();
        NodeList bookList = doc.getElementsByTagName("Book");
        for (int i = 0; i < bookList.getLength(); i++) {
            Element book = (Element) bookList.item(i);
            System.out.println("Book " + (i + 1) + ":");
            System.out.println("Title: " + book.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Published Year: " + book.getElementsByTagName("publishedYear").item(0).getTextContent());
            System.out.println("Number of Pages: " + book.getElementsByTagName("numberOfPages").item(0).getTextContent());
            NodeList authors = book.getElementsByTagName("author");
            System.out.print("Authors: ");
            for (int j = 0; j < authors.getLength(); j++) {
                System.out.print(authors.item(j).getTextContent());
                if (j < authors.getLength() - 1) System.out.print(", ");
            }
            System.out.println("\n");
        }
    }

    // Parse JSON file
    private static JSONObject parseJSON(String filePath) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    }

    // Print JSON content
    private static void printJSON(JSONObject json) {
        JSONArray books = json.getJSONObject("BookShelf").getJSONArray("Book");
        for (int i = 0; i < books.length(); i++) {
            JSONObject book = books.getJSONObject(i);
            System.out.println("Book " + (i + 1) + ":");
            System.out.println("Title: " + book.getString("title"));
            System.out.println("Published Year: " + book.getInt("publishedYear"));
            System.out.println("Number of Pages: " + book.getInt("numberOfPages"));
            System.out.print("Authors: ");
            JSONArray authors = book.getJSONArray("authors");
            for (int j = 0; j < authors.length(); j++) {
                System.out.print(authors.getString(j));
                if (j < authors.length() - 1) System.out.print(", ");
            }
            System.out.println("\n");
        }
    }

    // Add a new book to XML
    private static void addBookToXML(Document doc) throws Exception {
        Element root = doc.getDocumentElement();
        Element newBook = doc.createElement("Book");

        Element title = doc.createElement("title");
        title.setTextContent("Pride and Prejudice");
        newBook.appendChild(title);

        Element publishedYear = doc.createElement("publishedYear");
        publishedYear.setTextContent("1813");
        newBook.appendChild(publishedYear);

        Element numberOfPages = doc.createElement("numberOfPages");
        numberOfPages.setTextContent("432");
        newBook.appendChild(numberOfPages);

        Element authors = doc.createElement("authors");
        Element author = doc.createElement("author");
        author.setTextContent("Jane Austen");
        authors.appendChild(author);
        newBook.appendChild(authors);

        root.appendChild(newBook);

        // Save the updated XML to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("/Users/zhenting/INFO5100_002304821_ChenTingKuo/exercises/exercise8/books.xml"));        transformer.transform(source, result);
    }

    // Add a new book to JSON
    private static void addBookToJSON(JSONObject json) throws Exception {
        JSONArray books = json.getJSONObject("BookShelf").getJSONArray("Book");

        JSONObject newBook = new JSONObject();
        newBook.put("title", "Pride and Prejudice");
        newBook.put("publishedYear", 1813);
        newBook.put("numberOfPages", 432);
        newBook.put("authors", new JSONArray().put("Jane Austen"));

        books.put(newBook);

        // Save the updated JSON to file
        try (FileWriter file = new FileWriter("/Users/zhenting/INFO5100_002304821_ChenTingKuo/exercises/exercise8/books.json")) {
            file.write(json.toString(4));
        }
    }
}


