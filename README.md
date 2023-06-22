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
> Android ->

### 사전 준비 사항

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위해 사전에 필요한 준비 사항들을 적어주세요.**
- Android : AndroidStdio에서 빌드한 .APK 앱 파일, app Center 계정,
- Web : github계정, Azure계정
## 시작하기

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위한 절차를 구체적으로 나열해 주세요.**
- Android ->
<br>
<br>
- Backend
<br>
 ## 1. [Azure포털](https://portal.azure.com/#home)로 이동합니다.
 ## 2. App Services [웹 앱] 만들기를 만듭니다.
 ## 3. `정적 웹앱`을 생성합니다.
 ## 4. 총 2개의 서비스를 생성합니다.
 <br>
 `기본`
  <br>
|설정|값|
|:---|:---|
|이름|readme-user-service|
|게시|코드|
|런타임 스택|Java 17 SE|
|운영체제|Linux|
|지역|east asia|
 <br>
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
<br>
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
