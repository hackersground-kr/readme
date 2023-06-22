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
        </S.User>
        <S.Waiting>추천대기</S.Waiting>
        <S.Line3 />
        <S.WaitingUsers>추천대기</S.WaitingUsers>
      </S.RecommendingUsers>
    </div>
  );
};

export default UserRecommand;
