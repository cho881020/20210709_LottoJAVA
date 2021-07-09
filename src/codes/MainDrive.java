package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

		int[] myLottoNumbers = new int[6];

//		숫자 6개 => 내 로또 번호를 입력받기 위한 for문.

		Scanner myScan = new Scanner(System.in);

		for (int i = 0; i < myLottoNumbers.length; i++) {

//			숫자를 입력받아서 -> 조건 검사를 모두 통과하면 -> 집어넣자.
//			집어넣었다 : 다음 숫자 입력받으러 이동 (for 문 다음바퀴로 이동)
//			통과못했다 : 다시 입력받자. => 검사 통과할때까지 계속 입력받자.

			while (true) {

//				숫자 입력 : Scanner 필요. => 여기서 만들면 계속 스캐너를 새로 장만하는 형태.
//				for문 보다도 앞에 Scanner를 만들어두고, 여기서는 활용만 하자.

//				안내문구 : ?번째 숫자 입력
				System.out.print((i + 1) + "번째 숫자 입력 : ");

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
				} else if (!isRangeOk) {
					System.out.println("1~45의 숫자만 입력가능합니다.");
				} else {
					System.out.println("이미 입력한 숫자입니다.");
				}

			}

		}

//		컴퓨터가 6개의 랜덤 숫자를 뽑아서 => 이번주 당첨번호를 추첨.

		int[] winLottoNumbers = new int[6];

//		6개의 숫자를 넣기 위한 for

		for (int i = 0; i < winLottoNumbers.length; i++) {

//			중복검사 통과하는 숫자를 뽑을때까지 무한반복.

			while (true) {
				
//			컴퓨터가 랜덤 숫자 제시 => 1~45 사이의 숫자를 랜덤으로 추출 : 범위검사는 필요가 없다.

				int randomNum = (int) (Math.random() * 45 + 1);

//			중복검사 만 해도 되겠다.
				boolean isDuplOk = true;

				for (int num : winLottoNumbers) {
					if (num == randomNum) {
						isDuplOk = false;
						break;
					}
				}

//			중복검사만 통과했어도 배열에 넣어도 된다.

				if (isDuplOk) {
					winLottoNumbers[i] = randomNum;
					break;
				}
			}

		}
		
		
//		등수 판단 => 내 번호 / 당첨번호 비교. => 몇개를 맞췄나 (같은 숫자가 몇개 있는가?)
//		숫자야구게임과의 비교 : 야구 - 위치도 판단 요소. / 로또 - 위치는 상관 없다.
		
		
//		몇개의 숫자를 맞췄는지 기록할 변수.
		int correctNumCount = 0;
		
//		내 번호를 하나씩 꺼내보자.
		for (int myNum :  myLottoNumbers) {
			
//			당첨번호도 하나씩 꺼내보자. => 내 번호랑 계속 같은지? 비교
			for (int winNum : winLottoNumbers) {
				
				if (myNum == winNum) {
					
//					같은 숫자를 찾았다면 => 맞춘 갯수 하나 증가.
					correctNumCount++;
				}
				
			}
			
		}
		

//		최종 결과 : 맞춘 갯수가 저장됨.
//		이 갯수가 몇개냐에 따라 등수를 정해주자.
		
		if (correctNumCount == 6) {
			System.out.println("1등");
		}
		else if (correctNumCount == 5) {
			System.out.println("3등");
		}
		else if (correctNumCount == 4) {
			System.out.println("4등");
		}
		else if (correctNumCount == 3) {
			System.out.println("5등");
		}
		else {
			System.out.println("낙첨");
		}
		
		
		

	}

}








