import React from "react";

import pencil from "../../../assets/img/pencil.png";

import * as S from "./style";

export const EditIntroduceC = () => {
  return (
    <S.Box>
      <S.GroupWrapper>
        <S.Group>
          <S.Overlap>
            <S.RectangleWrapper>
              <S.Rectangle />
            </S.RectangleWrapper>
            <S.Div />
            <S.TextWrapper>
              대구 구지면에 위치한 이찬혁컴퍼니입니다
              <br />
              대구 구지면에 위치한 이찬혁컴퍼니입니다
              <br />
              대구 구지면에 위치한 이찬혁컴퍼니입니다
              <br />
              대구 구지면에 위치한 이찬혁컴퍼니입니다
              <br />
              대구 구지면에 위치한 이찬혁컴퍼니입니다
              <br />
              대구 구지면에 위치한 이찬혁컴퍼니입니다
            </S.TextWrapper>
          </S.Overlap>
          <S.H1>회사 설명</S.H1>
          <S.Image alt="Image" src={pencil} />
          {/* <S.OverlapGroupWrapper>
            <S.OverlapGroup>
              <S.TextWrapper2>수정</S.TextWrapper2>
            </S.OverlapGroup>
          </S.OverlapGroupWrapper> */}
        </S.Group>
      </S.GroupWrapper>
    </S.Box>
  );
};
