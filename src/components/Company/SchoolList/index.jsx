import React, { useEffect, useState } from "react";
import * as S from "./style";
import axios from "axios";

export const SchoolList = () => {
  const [schoolList, setSchoolList] = useState([]);

  const getSchoolList = async () => {
    try {
      const URL = `https://readme-api-manager.azure-api.net/search/school/name?name=`;
      const response = await axios.get(URL, {
        headers: {
          Authorization: localStorage.getItem("accessToken"),
        },
      });
      setSchoolList(response.data.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getSchoolList();
  }, []);

  return (
    <div>
      <S.Title>학교 목록</S.Title>
      <S.Line />
      <S.Users>
        {schoolList.map((school, index) => (
          <S.User key={index}>
            <S.UserName>{school.name}</S.UserName>
            <S.UserSchool>{school.name}</S.UserSchool>
            <S.UserEmail>{school.email}</S.UserEmail>
          </S.User>
        ))}
      </S.Users>
    </div>
  );
};
