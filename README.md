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
## 2. 안드로이드 스튜디오를 실행 시킨뒤 상단에 있는 Open버튼을 클릭한뒤 클론받은 안드로이드 코드를 Open한다(안드로이드 빌드를 한번도 하지 않은 노트북이나 텀퓨터이면 빌드하는데 오래 걸릴것이다)
<img width="307" alt="스크린샷 2023-06-22 오후 9 01 20" src="https://github.com/hackersground-kr/readme/assets/89149734/89345405-7f8a-4d63-b532-45cdd3456dfe">

## 3. 빌드가 다 받아져 왼쪽 상단에 Project가 Android로 변한다면 상단바에 Build(클릭) -> Build 
Bundle(s) / APK(s) -> Build APK(s)(클릭)
<img width="479" alt="Screenshot 2023-06-23 at 6 47 50 AM" src="https://github.com/hackersground-kr/readme/assets/101560702/5ee7656a-a6cf-4947-8286-1c3b7b140aa5">

<img width="206" alt="Screenshot 2023-06-23 at 6 44 27 AM" src="https://github.com/hackersground-kr/readme/assets/101560702/45660d9e-db92-4d72-9a70-0e2bb6ca4c64"><img width="223" alt="Screenshot 2023-06-23 at 6 46 55 AM" src="https://github.com/hackersground-kr/readme/assets/101560702/b579acfb-a7e2-410a-8366-f09c3fa8261a">

`만약 오류가 발생한다면 버전을 체크해보자.` : `settings > Updates > CheckForUpdates`<img width="983" alt="스크린샷 2023-06-22 오후 9 14 22" src="https://github.com/hackersground-kr/readme/assets/89149734/fce88eda-87b9-4184-8f7e-ca2f987131a0">
### 버전 Java 17, Android 13(API33), 

## 4. 안드로이드 스튜디오 오른쪽 밑에 Build APK(s) 창이 나온것을 확인 한후 locate를 클릭한다 그리고 나오는 .APK파일 위치를 기억한다
## 5. https://appcenter.ms/apps 사이트에 들어가 SIGN IN을 클릭하여 로그인을 한다 필요할 경우 회원가입을 한다
## 6. 로그인이 완료 되었을 경우 오른쪽 위에 있는 Add new 파란색 버튼을 클릭한다.
## 7. Add new organization를 선택한후 자신이 원하는 App organization이름을 적고 오른쪽 밑에 파랑색 버튼을 클릭하면 organization이 만들어진다, 그다음으로 Add app을 클릭하면 Add new app작은 페이지가 나올것이다 App name을 자신이 원하는데로 영어로 적어준다 그다음으로는 OS를 Android로 변경 시켜주고 Platform은 Java/Kotlin으로 변경 시켜준다, 마지막으로 Add new app을 클릭해주면 생셩된다.
## 8. Group Name은 영어로 만들어주면 되고 Allow public access를 ON으로 해준다(이걸으로 앱을 배포하면 모든 사람들이 다운 받을수 있다) 그리고 Create Group을 클릭해준다
## 9. 중간에 파란색버튼으로 Distribute new release버튼이 보일것이다 그것을 클릭하면 배포하고 싶은 .APK파일을 열어준다(업로드 하는데 시간이 좀 걸린다) 업로드가 마치면 Next버튼이 활성화 되어있을것이다 그것을 클릭하면 다음으로 넘어가고 New release가 나오는데 그건 Next버튼을 다시 눌러 넘어가면된다
## 10. 마지막으로 Distribute 파란색 버튼이 나오는데 그걸을 클릭하면 이제 앱을 배포할 준비가 끝이 났다.
## 11. 오른쪽위에 보시면 다운로드 icon이 있을것이다 그걸을 클릭하면 핸드폰이면 바로 바로 다운로드 창으로 넘어 갈수도 있고 로그인 창이 나올수도 있다 로그인 창이 나오면 로그인을 하시면 된다, 그리고 데스크탑으로 들어갔다면 QR코드가 나올것이다 그것을 안드로이드 핸드폰으로 스캔하면 다운로드 창이 나올수도 있고 로그인 창이나올수도 있다 로그인 창이 나온다면 로그인을 하시면 된다(만약 핸드폰버전 보다 배포한 안드로이드 앱이 더 높다면 안드로이드 앱실행이 안될것이다(물론 그건은 지극지 정상적인 일이다)) -이상무-

<br>

- Backend

 ## 1. [Azure포털](https://portal.azure.com/#home)로 이동합니다.
 ## 2. App Services [웹 앱] 만들기를 만듭니다.
 ## 3. `정적 웹앱`을 생성합니다. 총 2개
 `1 번째`
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

 `2 번째`
 `기본`
  <br>
|설정|값|
|:---|:---|
|이름|readme-search-service|
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
|분기|back-search-service 선택|

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

 ## ! 두 서비스 모드 cors를 허용해 주어야 함 !

<br>

 ## 7. readme-api-manager > api > Create from Azure resource > App Service 정의
 ## 8. browse를 누르고 이전에 만든 readme-user-service 선택 > API URL suffix 는 user로 맟추고 생성
 ## 9. 한번더 browse를 누르고 이전에 만든 readme-search-service 선택 > API URL suffix 는 search로 맟추고 생성
 ## 10. Apis의 api > 두 API를 각각 선택한 후 Inbound processing에 policies 추가 > cors 선택 후..
 origin
 https://orange-water-0be200a00.3.azurestaticapps.net
 http://192.168.225.26:3000
 methods
 *
 headers
 *
 로 설정

<br>

- Web
 ## 1. [Azure포털](https://portal.azure.com/#home)로 이동합니다.
 ## 2. 리소스 만들기를 선택합니다.
 ## 3. `정적 웹앱`을 검색합니다.
 ## 4. 정적 웹앱을 선택합니다. 
 ## 5. 만들기를 클릭합니다.
 ## <img width="752" alt="1" src="https://github.com/hackersground-kr/readme/assets/89149734/5897c5a8-59ae-4730-9ead-416ef39b866a">
 
 <br>
 
|설정|값|
|:---|:---|
|구독|Azure 구독을 선택합니다.|
|리소스 그룹|rg-hg-readme를 선택합니다.|
|이름|ReadMe-Web을 입력합니다.|
|계획 유형|무료 선택|
|Azure Functions API 및 스테이징 환경을 위한 영역|East Asia선택|

## <img width="740" alt="2" src="https://github.com/hackersground-kr/readme/assets/89149734/4576c9ea-c26c-4416-bb38-1acab7bc6a32">

<br>

|설정|값|
|:---|:---|
|원본|GitHub 선택|
|조직|hackersground-kr 선택|
|리포지토리|readme 선택|
|분기|Web 선택|

## <img width="748" alt="3" src="https://github.com/hackersground-kr/readme/assets/89149734/3d3d3783-4a6d-4060-ad1e-aaf2bd262fd9">

<br>

|설정|값|
|:---|:---|
|빌드 사전 설정|React 선택|
|앱 위치| / 입력|
나머진 수정 X

## 6. 검토 + 만들기 클릭
