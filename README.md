# `ALT` - `ReadMe`

해커그라운드 해커톤에 참여하는 `ALT` 팀의 `ReadMe`입니다.

## 참고 문서

> 아래 두 링크는 해커톤에서 앱을 개발하면서 참고할 만한 문서들입니다. 이 문서들에서 언급한 서비스 이외에도 더 많은 서비스들이 PaaS, SaaS, 서버리스 형태로 제공되니 참고하세요.

- [순한맛](./REFERENCES_BASIC.md)
- [매운맛](./REFERENCES_ADVANCED.md)

## 제품/서비스 소개
<!-- 아래 링크는 지우지 마세요 -->
[제품/서비스 소개 보기](TOPIC.md)
<!-- 위 링크는 지우지 마세요 -->

## 오픈 소스 라이센스

<!-- 아래 링크는 지우지 마세요 -->
[오픈소스 라이센스 보기](./LICENSE)
<!-- 위 링크는 지우지 마세요 -->

## 설치 방법

> **아래 제공하는 설치 방법을 통해 심사위원단이 여러분의 제품/서비스를 실제 Microsoft 애저 클라우드에 배포하고 설치할 수 있어야 합니다. 만약 아래 설치 방법대로 따라해서 배포 및 설치가 되지 않을 경우 본선에 진출할 수 없습니다.**


### 사전 준비 사항

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위해 사전에 필요한 준비 사항들을 적어주세요.**
- Android : 노트북, 안드로이드 스튜디오, app Center 계정, 와이파이, Java 17버전, Compile Sdk Version API 33: Android 13.0, Git
- Web : github계정, Azure계정
## 시작하기

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위한 절차를 구체적으로 나열해 주세요.**
- Android
## 1. Github에서 Readme 레토지포리에 있는 Android2 브런치 코드를 클론받는다.
```
$ git clone https://github.com/hackersground-kr/readme.git
$ git checkout Android2
```
## 2. 안드로이드 스튜디오를 실행 시킨뒤 상단에 있는 Open버튼을 클릭한뒤 클론받은 안드로이드 코드를 Open한다
<img width="307" alt="스크린샷 2023-06-22 오후 9 01 20" src="https://github.com/hackersground-kr/readme/assets/89149734/89345405-7f8a-4d63-b532-45cdd3456dfe">

## 3. 안드로이드 스튜디오 상단라인에 있는 Build Bundle(s)(클릭) -> Build APK(s)를 클릭한다.
<img width="436" alt="스크린샷 2023-06-22 오후 9 06 56" src="https://github.com/hackersground-kr/readme/assets/89149734/b5f60beb-c348-41f2-be23-be84ad03e6af">

`만약 오류가 발생한다면 버전을 체크해보자.` : `settings > Updates > CheckForUpdates`<img width="983" alt="스크린샷 2023-06-22 오후 9 14 22" src="https://github.com/hackersground-kr/readme/assets/89149734/fce88eda-87b9-4184-8f7e-ca2f987131a0"><img width="238" alt="스크린샷 2023-06-22 오후 9 16 19" src="https://github.com/hackersground-kr/readme/assets/89149734/db83b931-0d5b-4923-89ba-ba5e70d00bb8">


## 4. 안드로이드 스튜디오 오른쪽 밑에 Build APK(s) 창이 나온것을 확인 한후 locate를 클릭한다 그리고 나오는 .APK파일 위치를 기억한다
## 5. https://appcenter.ms/apps 사이트에 들어가 SIGN IN을 클릭하여 로그인을 한다 필요할 경우 회원가입을 한다
## 6. 로그인이 완료 되었을 경우 오른쪽 위에 있는 Add new 파란색 버튼을 클릭한다.
## 7. Add new organization를 선택한후 자신이 원하는 App organization이름을 적고 오른쪽 밑에 파랑색 버튼을 클릭하면 organization이 만들어진다, 그다음으로 Add app을 클릭하면 Add new app작은 페이지가 나올것이다 App name을 자신이 원하는데로 영어로 적어준다 그다음으로는 OS를 Android로 변경 시켜주고 Platform은 Java/Kotlin으로 변경 시켜준다, 마지막으로 Add new app을 클릭해주면 생셩된다.
## 8. Group Name은 영어로 만들어주면 되고 Allow public access를 ON으로 해준다(이걸으로 앱을 배포하면 모든 사람들이 다운 받을수 있다) 그리고 Create Group을 클릭해준다
## 9. 중간에 파란색버튼으로 Distribute new release버튼이 보일것이다 그것을 클릭하면 배포하고 싶은 .APK파일을 열어준다(업로드 하는데 시간이 좀 걸린다) 업로드가 마치면 Next버튼이 활성화 되어있을것이다 그것을 클릭하면 다음으로 넘어가고 New release가 나오는데 그건 Next버튼을 다시 눌러 넘어가면된다
## 10. 마지막으로 Distribute 파란색 버튼이 나오는데 그걸을 클릭하면 이제 앱을 배포할 준비가 끝이 났다.
## 11. 오른쪽위에 보시면 다운로드 icon이 있을것이다 그걸을 클릭하면 핸드폰이면 바로 바로 다운로드 창으로 넘어 갈수도 있고 로그인 창이 나올수도 있다 로그인 창이 나오면 로그인을 하시면 된다, 그리고 데스크탑으로 들어갔다면 QR코드가 나올것이다 그것을 안드로이드 핸드폰으로 스캔하면 다운로드 창이 나올수도 있고 로그인 창이나올수도 있다 로그인 창이 나온다면 로그인을 하시면 된다 -이상무-

<br>

- Backend

 ## 1. [Azure포털](https://portal.azure.com/#home)로 이동합니다.
 ## 2. App Services [웹 앱] 만들기를 만듭니다.
 ## 3. `정적 웹앱`을 생성합니다.

 `기본`
  <br>
|설정|값|
|:---|:---|
|이름|readme-user-service|
|게시|코드|
|런타임 스택|Java 17 SE|
|운영체제|Linux|
|지역|east asia|

 `배포`
  <br>
|설정|값|
|:---|:---|
|원본|GitHub 선택|
|조직|hackersground-kr 선택|
|리포지토리|readme 선택|
|분기|back-user-service 선택|

 <br>

 ## 5. 검토후 생성합니다.

 ## 6. API Management 서비스를 생성합니다

  `기본`
  <br>
|설정|값|
|:---|:---|
|지역|(Asia Pacific)East Asia|
|리소스 이름|readme-api-manager|
|조직 이름|Alt|
|관리자 이메일|본인 이메일|
|사용량|99.95% SLA|

<br>

 ## 7. readme-api-manager > api > Create from Azure resource > App Service 정의
 ## 8. browse를 누르고 이전에 만든 readme-user-service 선택 > API URL suffix 는 user로 맟추고 생성

<br>

- Web
 ## 1. [Azure포털](https://portal.azure.com/#home)로 이동합니다.
 ## 2. 리소스 만들기를 선택합니다.
 ## 3. `정적 웹앱`을 검색합니다.
 ## 4. 정적 웹앱을 선택합니다. 
 ## 5. 만들기를 클릭합니다.
 ## <img width="772" alt="스크린샷 2023-06-22 오후 6 05 48" src="https://github.com/hackersground-kr/readme/assets/89149734/27288a3d-c912-4c85-a131-c2049357e161">
 
 <br>
 
|설정|값|
|:---|:---|
|구독|Azure 구독을 선택합니다.|
|리소스 그룹|rg-hg-readme를 선택합니다.|
|이름|ReadMe-Web을 입력합니다.|
|계획 유형|무료 선택|
|Azure Functions API 및 스테이징 환경을 위한 영역|East Asia선택|

<img width="763" alt="스크린샷 2023-06-22 오후 6 54 34" src="https://github.com/hackersground-kr/readme/assets/89149734/370cab71-4709-4c38-8342-4cbbceec420c">

<br>

|설정|값|
|:---|:---|
|원본|GitHub 선택|
|조직|hackersground-kr 선택|
|리포지토리|readme 선택|
|분기|Web 선택|

<img width="742" alt="스크린샷 2023-06-22 오후 6 58 22" src="https://github.com/hackersground-kr/readme/assets/89149734/0430b452-80e8-4bdb-b641-a36085859606">

<br>

|설정|값|
|:---|:---|
|빌드 사전 설정|React 선택|
|앱 위치| / 입력|
나머진 수정 X

## 6. 검토 + 만들기 클릭
