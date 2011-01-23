/**
 * Created by IntelliJ IDEA.
 * User: Ambidextrous
 * Date: Jan 22, 2011
 * Time: 4:38:34 PM
 * To change this template use File | Settings | File Templates.
 */

// Find the largest SxS square brush that can be used to fully
// paint an NxM picture such that all B cells within the picture
// are covered but none of the W cells within the picture are
// touched

import java.util.*;

public class Painting {
    
	public int largestBrush(String[] picture) {
        
		int N = picture.length;
		int M = picture[0].length();

		boolean [][] allBlacks = new boolean[N][M];

		boolean done = false;
		int S = Math.min(N, M);

		while(!done && S > 0) {
            boolean uberFlag = true;
			for(int i = 0; i < allBlacks.length; i++)
				for(int j = 0; j < allBlacks[i].length; j++)
					if(picture[i].charAt(j) == 'B')
						allBlacks[i][j] = true;
					else
						allBlacks[i][j] = false;

			System.out.println("In, S = " + S);

            for(int starti = 0; starti <= N - S; starti++)
                for(int startj = 0; startj <= M - S; startj++) {
                    boolean flag = true;
                    int endi = starti + S;
                    int endj = startj + S;
                    for(int i = starti; i < endi; i++)
                        for(int j = startj; j < endj; j++)
                            if(picture[i].charAt(j) == 'W')
                                flag = false;

                    if(flag)
                        for(int i = starti; i < endi; i++)
                            for(int j = startj; j < endj; j++)
                                allBlacks[i][j] = false;
                }
            
			for(int i = 0; i < allBlacks.length; i++)
				for(int j = 0; j < allBlacks[i].length; j++)
					if(allBlacks[i][j] == true)
						uberFlag = false;

			if(!uberFlag)
				S--;
			else
				done = true;

		}
		return S > 1 ? S : 1;
	}
}
//Powered by [KawigiEdit] 2.0!

