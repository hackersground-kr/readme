import React from "react";

import smile from "../../../assets/img/smile.png";
import img from "../../../assets/img/dummy.png";
import group from "../../../assets/svg/Group.svg";
import location from "../../../assets/svg/Location.svg";
// import image from "../../../assets/svg/image.svg";

import * as S from "./style";

export const EditInformationC = () => {
  return (
    <S.Box>
      <S.GroupWrapper>
        <S.Group>
          <S.Overlap>
            <S.TextWrapper>찬혁이회사</S.TextWrapper>
            <S.Element alt="Element" src={img} />
            <S.Line className="line" alt="Line" />
            <S.Line2 alt="Line" />
            <S.Line className="line-2" alt="Line" />
            <S.Div>학생수 : 40</S.Div>
            <S.Group2 alt="Group" src={group} />
            <S.P>위치 : 구지면 창리로 11길 93</S.P>
            {/* <S.OverlapGroupWrapper>
              <S.OverlapGroup>
                <S.TextWrapper2>사진 변경하기</S.TextWrapper2>
              </S.OverlapGroup>
            </S.OverlapGroupWrapper> */}
            {/* <S.OverlapWrapper>
              <S.DivWrapper>
                <S.TextWrapper3>수정</S.TextWrapper3>
              </S.DivWrapper>
            </S.OverlapWrapper> */}
            <S.IconLocation alt="Icon location" src={location} />
            {/* <S.IconImage alt="" src={image} /> */}

            <S.H1>학교 정보</S.H1>
            <S.Image alt="" src={smile} />
          </S.Overlap>
        </S.Group>
      </S.GroupWrapper>
    </S.Box>
  );
};
