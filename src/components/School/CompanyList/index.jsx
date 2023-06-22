import React, { useEffect, useState } from "react";
import * as S from "./style";
import axios from "axios";

export const CompanyList = () => {
  const [companyList, setCompanyList] = useState([]);

  const getCompanyList = async () => {
    try {
      const URL = `https://readme-api-manager.azure-api.net/search/enterprise/name?name=`;
      const response = await axios.get(URL, {
        headers: {
          Authorization: localStorage.getItem("accessToken"),
        },
      });
      setCompanyList(response.data.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getCompanyList();
  }, []);

  return (
    <div>
      <S.Title>기업 목록</S.Title>
      <S.Line />
      <S.Users>
        {companyList.map((company, index) => (
          <S.User key={index}>
            <S.UserName>{company.name}</S.UserName>
            <S.UserSchool>{company.name}</S.UserSchool>
            <S.UserEmail>{company.email}</S.UserEmail>
          </S.User>
        ))}
      </S.Users>
    </div>
  );
};
