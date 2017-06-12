package frontend;



import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.*;



public class MancalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MancalaServlet() {
        super();
       
    }
    void page(HttpServletRequest request, HttpServletResponse response, Mancala mancala) throws ServletException, IOException {
    	MancalaBean mb = new MancalaBean(mancala.getStones(), mancala.getCurrentTurn() + 1, mancala.getWinningPlayer(), mancala.getNumberOfWinningStones()) ;
    	request.setAttribute ("currentState", mb);
    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	rd.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("currentState") == null) {
			       session.setAttribute("currentState", new MancalaBean(new Mancala()));
		}
		Mancala mancala = ((MancalaBean) session.getAttribute("currentState")).getMancala(); 
		
        page(request,response, mancala);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MancalaBean mb = ((MancalaBean) session.getAttribute("currentState"));
		if (mb == null) {
			doGet(request,response);
		}
		else {
			Mancala man = mb.getMancala();
			BufferedReader read = request.getReader();
			try {
				String line = read.readLine();
				String split = line.split("=")[0];
				
					Integer location = Integer.parseInt(split);
					man.doMove(location - 7 * man.getCurrentTurn() + 1);
					
			
			}
			catch(NullPointerException npe) {
				npe.printStackTrace();
			}
			page(request,response,man);
		}
	}
}
	

