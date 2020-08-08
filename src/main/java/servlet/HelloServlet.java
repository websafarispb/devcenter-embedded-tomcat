package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import generator.BarecodeGenerator;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	BarecodeGenerator generatorBarcode = new BarecodeGenerator(); 
    	String sequence= "9123456789";
        String thName = req.getParameter("studentName");
        if(thName!=null)
        	sequence = thName;

    	try {
			generatorBarcode.generateBarcode(sequence);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PrintWriter writer = resp.getWriter();
		writer.println("Hello stuped");
     //   ServletOutputStream out = resp.getOutputStream();     
    //	out.write("<html> <body>		<h2>BarCode</h2>		<p>Barcode has been generated succeed</p> </body>	<img src=\"one.jpg\" alt=\"альтернативный текст\" />  <form action=\"hello\" method=\"GET\"> <input type=\"text\" name=\"studentName\" placeholder=\"What is you name?\"> <input type=\"submit\" /> </form> </html>".getBytes());
    //	out.write(("<html> <body>		<h2>BarCode</h2>		<p>Barcode has been generated succeed</p> </body>	  <form action=\"hello\" method=\"GET\"> <input type=\"text\" name=\"studentName\" placeholder=\"What is you name?\"> <input type=\"submit\" /> </form> </html>").getBytes());
    //    out.flush();
   //    out.close();
//        <form action="processFormVersionThree" method="GET">
//        <input type="text" name="studentName" placeholder="What is you name?">
//        <input type="submit" />
//    </form>
      //  PrintWriter writer = response.getWriter();
///		writer.println("		<html>		<body>		<h2>HTML Links</h2>		<p>HTML links are defined with the a tag:</p>		<a href=\" https://www.w3schools.com\">This is a link</a>		</body>		</html>");
    
   //     String thName = req.getParameter("studentName");
//        thName = thName.toUpperCase();
//        String result = "Yo -  Hi" + thName;
//        model.addAttribute("message", result);
//        return "helloworld";
    
    
    
    }
    
}
