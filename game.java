import java.io.*;


public class game
{
    public static String lastactionone = "";
    public static String lastactiontwo = "";
    public static String grudgetrackerone = "Cooperate";
    public static String grudgetrackertwo = "Cooperate";
    
	public static void main(String[] args) {
		Gamer(100, 5, 5, 20);
	}
	
	public static void Gamer(int n, int m, int p, int k)
	{   
            StringBuilder sb = new StringBuilder();
            sb.append("Generation");
            sb.append(',');
            sb.append("Tit-4-Tat");
            sb.append(',');
            sb.append("Grudger");
            sb.append(',');
            sb.append("Always Cooperate");
            sb.append(',');
            sb.append("Always Defect");
            sb.append(',');
            sb.append("Tit-4-Tat");
            sb.append(',');
            sb.append("Grudger");
            sb.append(',');
            sb.append("Always Cooperate");
            sb.append(',');
            sb.append("Always Defect");
            sb.append(',');
            sb.append("Total");
            sb.append(',');
	    sb.append("Tit-4-Tat");
            sb.append(',');
            sb.append("Grudger");
            sb.append(',');
            sb.append("Always Cooperate");
            sb.append(',');
            sb.append("Always Defect");
            sb.append(',');
            sb.append('\n');
        	    
	    char[] players = new char[n];
	        for (int i = 0; i<n; ++i)
	        {
	            if (i <n/4)                    
	            {
	                players[i] = 'T';
	            }
	        
	            if (i >=n/4 && i <n/2)
	            {
	                players[i] = 'G';
	            }
	        
	            if (i >=n/2 && i<(n/2 + n/4))
	            {
	                players[i] = 'C';
	            }
	        
	            if (i >=(n/2 + n/4) && i<n)
	            {
	                players[i] = 'D';
	            }
	        
	        }
	        
	       
	        
	    
	    
	    for(int v = 0; v<k; ++v) 
	    {
	        System.out.println(players);
	        int[] pointtotals = new int[n];
	        for (int a = 0; a<n; ++a)
	        {
	            for (int b =a+1; b<n; ++b)
	            {
	                char playerone = players[a];
	                char playertwo = players[b];
	                int[][] points = Sim(m, playerone, playertwo);
	                for (int vv =0; vv<m; ++vv)
	                {
	                    pointtotals[a] = pointtotals[a] + points[0][vv];
	                    pointtotals[b] = pointtotals[b] + points[1][vv];
	                }
	            }
	        }
	        
	        int tftpoints = 0;
	        int gpoints = 0;
	        int cpoints = 0;
	        int dpoints = 0;
	        
	        int tftplayers = 0;
	        int gplayers = 0;
	        int cplayers= 0;
	        int dplayers = 0;
	        
	        int genpoints =0;
	        
	        
	        for (int i = 0; i <n; ++i)
	        {
	            if (players[i] == 'T')
	            {
	                tftpoints = tftpoints + pointtotals[i];
	                ++tftplayers;
	            }
	            
	            if (players[i] == 'G')
	            {
	                gpoints = gpoints + pointtotals[i];
	                ++gplayers;
	            }
	            
	            if (players[i] == 'C')
	            {
	                cpoints = cpoints + pointtotals[i];
	                ++cplayers;
	            }
	            
	            if (players[i] == 'D')
	            {
	                dpoints = dpoints + pointtotals[i];
	                ++dplayers;
	            }
	        }
	        
	        genpoints = tftpoints + gpoints + cpoints + dpoints;
	        
	        double percentt = tftplayers *100 /n; 
	        double percentg = gplayers*100/n; 
	        double percentc = cplayers*100/n; 
	        double percentd = dplayers*100/n; 
	        
	        int tftaverage = tftpoints/tftplayers;
	        int gaverage = gpoints/gplayers;
	        int caverage = cpoints/cplayers; 
	        int daverage = 0;
	        if (dplayers != 0)
	        {
	           daverage = dpoints/dplayers; 
	        }
	        
	        System.out.println("T4T Players: " + tftplayers );
	        
	        System.out.println("Gen " + v + ": T4T: " + percentt + "%  G: " + percentg + "%  AC: " + percentc + "%  AD: " + percentd + "%");
	        System.out.println("Gen " + v + ": T4T: " + tftpoints + " G: " + gpoints + " AC: " + cpoints + " AD: " + dpoints + " Total: " + genpoints);
	        System.out.println("Gen " + v + ": T4T: " + tftaverage + " G: " + gaverage + " AC: " + caverage + " AD: " + daverage);

                sb.append(String.valueOf(v));
                sb.append(',');
                sb.append(String.valueOf(percentt));
                sb.append(',');
                sb.append(String.valueOf(percentg));
                sb.append(',');
                sb.append(String.valueOf(percentc));
                sb.append(',');
                sb.append(String.valueOf(percentd));
                sb.append(',');
                sb.append(String.valueOf(tftpoints));
                sb.append(',');
                sb.append(String.valueOf(gpoints));
                sb.append(',');
                sb.append(String.valueOf(cpoints));
                sb.append(',');
                sb.append(String.valueOf(dpoints));
                sb.append(',');
                sb.append(String.valueOf(genpoints));
                sb.append(',');
	        sb.append(String.valueOf(tftaverage));
                sb.append(',');
                sb.append(String.valueOf(gaverage));
                sb.append(',');
                sb.append(String.valueOf(caverage));
                sb.append(',');
                sb.append(String.valueOf(daverage));
                sb.append(',');
                sb.append('\n');    
	        
	        System.out.println("");
	        for(int z = 0; z<n; ++z)
	        {
	            
	            System.out.print(" "+pointtotals[z]);
	        }	


	        /* Need to take out bottom p% of players from the array here and replace them with a copy of the top p% of players*/
	        int takeout = p*n/100;
	        
	        int[] poptotakeout = new int[takeout];
	        int[] poptocopy = new int[takeout];
	        
	        for (int g=0; g<takeout; ++g)
	        {
	           int tempvar = 100000000;
	           int tempchar = -1;
                   int[] tr = new int[n];
                   int trtracker = 0;
	           for (int f =0; f<n; ++f)
	           {
	               if (pointtotals[f] != -1)
	               {
	                   if (pointtotals[f] < tempvar )
	                   {
	                       tempchar = f;  
	                       tempvar = pointtotals[f];
	                       tr = new int[n];
	                       trtracker=0;
                               tr[0] = f;
                               ++trtracker; 
	                   }

                           else if(pointtotals[f] == tempvar)
                           {
                               tr[trtracker] = f; 
                               ++trtracker;
			               }
	               }
	           }
	           int index = (int)(Math.random() * trtracker);
	           poptotakeout[g] = tr[index]; /* tempchar */
	           pointtotals[tr[index]] = -1;
	            
	        }
	        
	        
	        for (int g=0; g<takeout; ++g)
	        {
	           int tempvar = pointtotals[0];
	           int tempchar = 0;
                   int[] tr = new int[n];
                   int trtracker = 0;
	           for (int f =0; f<n; ++f)
	           {
	               if (pointtotals[f] != -1)
	               {
	                   if (pointtotals[f] > tempvar )
	                   {
	                       tempchar = f;  
	                       tempvar = pointtotals[f];
	                       tr = new int[n];
	                       trtracker=0;
                               tr[0] = f;
                               ++trtracker; 
	                   }

                           else if(pointtotals[f] == tempvar)
                           {
                               tr[trtracker] = f; 
                               ++trtracker;
			   }
	               }
	           }
	           
                   int index = (int)(Math.random() * trtracker);
	           poptocopy[g] = tr[index]; /* tempchar */
	        
	           pointtotals[tr[index]] = -1;
	            
	        }
	        
	        for (int g=0; g<takeout; ++g)
	        {
	            players[poptotakeout[g]] = players[poptocopy[g]];
	        }


	        
	     }
	    
             try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

              writer.write(sb.toString());

              System.out.println("done!");

             } 
             catch (FileNotFoundException e) {
               System.out.println(e.getMessage());
             } 
	    
	}
	
	public static int[][] Sim(int m, char Typeone, char Typetwo)
	{
	   int payoffone[] = new int[m];
	   int payofftwo[] = new int[m];
	   for (int j = 0; j <m; ++j)  
	   {
	       String lone = lastactionone;
	       String ltwo = lastactiontwo;
	       int[] ans = Game(Typeone, Typetwo, lone, ltwo);
	       payoffone[j] = ans[0];
	       payofftwo[j] = ans[1];
	   }
	   
	   grudgetrackerone = "Cooperate";
	   grudgetrackertwo = "Cooperate";
           lastactionone = "";
           lastactiontwo = "";
	   
	   int[][] fullpayoffs = new int[2][m];
	   for (int u = 0; u<m; ++u)
	   {
	       fullpayoffs[0][u] = payoffone[u];
	       fullpayoffs[1][u] = payofftwo[u];
	   }
	   
	   return fullpayoffs;
	}
	
	public static int[] Game(char Typeone, char Typetwo, String lastone, String lasttwo)
	{
	   String actionone = "";
	   String actiontwo = "";
	   
	   if (Typeone == 'T' && lastone == "")
	   {
	       actionone = "Cooperate";
	   }
	   
	   else
	   {
	       actionone = lasttwo;
	   }
	   
	   if (Typeone == 'G')
	   {
	       if (lasttwo == "Defect")
	       {
	           grudgetrackerone = "Defect";
	       }
	       
	       actionone = grudgetrackerone;
	   }
	   
	   if (Typeone == 'C')
	   {
	       actionone = "Cooperate";
	   }
	   
	   if (Typeone == 'D')
	   {
	       actionone = "Defect";
	   }
	   
	   
	   if (Typetwo == 'T' && lasttwo == "")
	   {
	       actiontwo = "Cooperate";
	   }
	   
	   else
	   {
	       actiontwo = lastone;
	   }
	   
	   if (Typetwo == 'G')
	   {
	       if (lastone == "Defect")
	       {
	           grudgetrackertwo = "Defect";
	       }
	       
	       actiontwo = grudgetrackertwo;
	   }
	   
	   if (Typetwo == 'C')
	   {
	       actiontwo = "Cooperate";
	   }
	   
	   if (Typetwo == 'D')
	   {
	       actiontwo = "Defect";
	   }
	   
	   int[] payoff = Pay(actionone, actiontwo);
	   
	   lastactionone = actionone;
	   lastactiontwo = actiontwo;
	   
	   return payoff;
	   
	}
	
	public static int[] Pay(String x, String y)
	{
	  int[] values = new int[2];  
	  if (x == "Cooperate" && y == "Cooperate")
	  {
	      values[0] = 3;
	      values[1] = 3;
	  }
	  
	  if (x == "Cooperate" && y == "Defect")
	  {
	      values[0] = 0;
	      values[1] = 5;
	  }
	  
	  if (x == "Defect" && y == "Cooperate")
	  {
	      values[0] = 5;
	      values[1] = 0;
	  }
	  
	  if (x == "Defect" && y == "Defect")
	  {
	      values[0] = 1;
	      values[1] = 1;
	  }
	  
	  return values;
	  
	}
	
	
}
