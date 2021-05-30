# STM 시험지 자동 제작

![GitHub last commit](https://img.shields.io/github/last-commit/LeeDongGeon1996/STM)

WYSIWYG Editor를 사용하여 시험지를 One-click 제작. 📃
<br>
<img src="https://user-images.githubusercontent.com/38756230/120101342-a3063600-c180-11eb-83e9-00e25cb66704.png" width=300 align=right>


**개발 프로젝트명**: STM<br>
**프로젝트 기간**: 2018.06~2018.11(약 5개월)
<br><br>

# 기술 스택

|Category| - |
| --- | --- |
|Language|Java 1.6|
|Web Server|Tomcat 8.5|
|Web Framework|Spring Framework 5.0.3|
|Database|MongoDB|
|WYSIWYG Editor|CKEditor|

# 개발 동기

학원에서 학생 관리 업무를 하던 도중에 선생님들의 반복적인 시험지 제작 과정을 보고 자동화의 필요성을 느꼈습니다. 실제로 프로젝트 타당성 조사를 하면서 여러 선생님들로부터 시험지 제작의 고충을 듣게 되었고 저희는 클릭 몇 번이면 시험지를 제작할 수 있도록 프로그램을 개발하게 되었습니다.

먼저 기존에 비슷한 기능을 제공하는 서비스들은 제공되는 문제로만 구성이 가능하거나  시험지 양식을 변경할 수 없었습니다. 또한 그마저도 유료 서비스로 제공되어 선뜻 사용하기에는 망설여진다는 현장의 소리를 듣게 되었습니다. 저희 **STM 시험지 자동 제작 서비스**는 사용자가 직접 문제를 등록하고 이미지를 첨부하여 자신만의 문제은행을 구축 할 수 있습니다. 또한 WYSIWYG Editor를 사용하여 시험지가 제작 되기에 사용자는 에디터에서 직접 시험지 양식을 수정 및 커스터마이징 가능합니다. 


# 개발 의의
 * JAVA + Spring Framework 사용.
 * MVC 아키텍쳐 패턴 적용.
 * Bridge 패턴 사용 - 인터페이스와 구현을 분리하여 유지보수성 증대.
 * WYSIWYG Editor API를 사용하여 노코드 방식으로 HTML 시험지 제작.
 * 첫번째 풀 스택 개발 프로젝트
    > Back-End: 이동건, 최준만<br>
    > Front-End: 최준만<br>
    > Design: 김해련<br>
    > WYSIWYG Editor: 이동건 


 
# 서버 구조
<img src="https://user-images.githubusercontent.com/38756230/120101311-810cb380-c180-11eb-88bf-854f043144b0.png" width=600 >


# Demo

[![Youtube](https://i.imgur.com/FfhxaRa.jpg)](https://www.youtube.com/watch?v=YyDl2aqG6u8)

# Samples

프로젝트 포스터             |
:-------------------------:|
![](https://i.imgur.com/zcJUBws.png)  |


시험지 제작 샘플             |
:-------------------------:|
![](https://i.imgur.com/NhpXn1F.png)  |
