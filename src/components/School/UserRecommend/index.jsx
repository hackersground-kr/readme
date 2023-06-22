import React from "react";

import * as S from "./style";

const UserRecommand = () => {
  return (
    <div>
      <S.Title>학생 추천</S.Title>
      <S.Line />
      <S.Recommending>추천중</S.Recommending>
      <S.Line2 />
      <S.RecommendingUsers>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
          <S.NoButton>취소</S.NoButton>
        </S.User>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
          <S.NoButton>취소</S.NoButton>
        </S.User>
        <S.Waiting>추천대기</S.Waiting>
        <S.Line3 />
        <S.WaitingUsers>
          <S.User>
            <S.UserName>김명봉</S.UserName>
            <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
            <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
            <S.YesButton>추천</S.YesButton>
          </S.User>
          <S.User>
            <S.UserName>김명봉</S.UserName>
            <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
            <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
            <S.YesButton>추천</S.YesButton>
          </S.User>
          <S.User>
            <S.UserName>김명봉</S.UserName>
            <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
            <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
            <S.YesButton>추천</S.YesButton>
          </S.User>
        </S.WaitingUsers>
      </S.RecommendingUsers>
    </div>
  );
};

export default UserRecommand;
