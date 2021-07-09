package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
		int[] myLottoNumbers = new int[6];
		
//		숫자 6개 => 내 로또 번호를 입력받기 위한 for문.
		
		Scanner myScan = new Scanner(System.in);
		
		for (int i=0 ; i < myLottoNumbers.length ; i++) {
			
//			숫자를 입력받아서 -> 조건 검사를 모두 통과하면 -> 집어넣자.
//			집어넣었다 : 다음 숫자 입력받으러 이동 (for 문 다음바퀴로 이동)
//			통과못했다 : 다시 입력받자. => 검사 통과할때까지 계속 입력받자.
			
			while (true) {
				
//				숫자 입력 : Scanner 필요. => 여기서 만들면 계속 스캐너를 새로 장만하는 형태.
//				for문 보다도 앞에 Scanner를 만들어두고, 여기서는 활용만 하자.
				
//				안내문구 : ?번째 숫자 입력
				System.out.print((i+1)+"번째 숫자 입력 : ");
				
//				일단 입력받은 숫자를 변수에 담아두고 => 변수가 검사를 통과하면 배열에 넣자.
				
				int inputNum = myScan.nextInt();
				
				
//				검사 1. 숫자 범위 검사. 1~45 사이인가?
				
//				검사 결과 통과/탈락 (true / false) : boolean 변수로 결과를 저장하자.
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45);
				
				
//				검사 2. 중복이 있는가? 내 로또번호에 이미 같은 숫자가 들어있는가?
				
				
//				일단 써도 된다고 해둔 다음 => 내 로또번호들을 확인하다가 => 같은걸 발견하는 순간, 중복이다. (쓰면 안된다) 로 값 변경.
				boolean isDuplicateOk = true; 
				
//				 중복검사 : 내 로또번호 목록에서 하나씩 꺼내보자 (for-each). => 입력한 숫자랑 같은가? => 같다면 더이상 사용하면 안됨.
				for (int myNum : myLottoNumbers) {
					
					if (myNum == inputNum) {
//						중복 발견!
						isDuplicateOk = false;
						break;
					}
					
				}
				
				
//				두개의 검사를 모두 통과했다면, => 배열에 입력값을 대입 + 다음숫자 받으러 이동.
				
				if (isRangeOk && isDuplicateOk) {
//					배열의 i번째 자리에 입력값 대입.
					myLottoNumbers[i] = inputNum;
					
//					다음숫자 입력받으러 이동. => 무한반복을 깨주자. (for문이 다음바퀴로 이동)
					break;
				}
				else if (!isRangeOk) {
					System.out.println("1~45의 숫자만 입력가능합니다.");
				}
				else {
					System.out.println("이미 입력한 숫자입니다.");
				}
				
				
				
			}
			
			
			
		}
		
	}

}
