import axios from "axios";
import { useCallback, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastError, ToastSuccess, ToastWarning } from "../lib/Toast";

export const useSignup = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [selectOption, setSelectOption] = useState("");
  const [selectedType, setSelectedType] = useState("");
  const [userNumber, setUserNumber] = useState("");
  const [userType, setUserType] = useState("");
  const [userAdress, setUserAdress] = useState("");

  const School_URL = `https://readme-api-manager.azure-api.net/user/signup/school`;
  const Company_URL = `https://readme-api-manager.azure-api.net/user/signup/company`;

  const onSignUpChange = useCallback((e) => {
    if (e.target.name === "email") {
      setEmail(e.target.value);
    } else if (e.target.name === "password") {
      setPassword(e.target.value);
    } else if (e.target.name === "school") {
      setSelectOption(e.target.value);
      setUserType("school");
    } else if (e.target.name === "company") {
      setSelectOption(e.target.value);
      setUserType("company");
    } else if (e.target.id === "H") {
      setSelectedType(e.target.id);
    } else if (e.target.id === "u") {
      setSelectedType(e.target.id);
    } else if (e.target.id === "U") {
      setSelectedType(e.target.id);
    } else if (e.target.id === "N") {
      setSelectedType(e.target.id);
    } else if (e.target.name === "student") {
      setUserNumber(e.target.value);
    } else if (e.target.name === "adress") {
      setUserAdress(e.target.value);
    }
  }, []);

  const onSignUpSubmit = useCallback(
    async (e) => {
      e.preventDefault();

      if (email && password) {
        if (userType === "school") {
          try {
            // console.log(email, password, selectOption, selectedType, userNumber, URL);
            const response = await axios.post(School_URL, {
              headers: {
                "Ocp-Apim-Subscription-Key": "39f12545fd02451aa9e865348e0e4151",
              },
              name: selectOption,
              email: email,
              password: password,
              location: userAdress,
              schoolType: selectedType,
              student: userNumber,
            });
            console.log(response);
            ToastSuccess("회원가입에 성공하였습니다.");
            navigate("/login");
          } catch (error) {
            ToastError("회원가입에 실패했습니다.\n관리자에게 문의해주세요");
          }
        } else if (userType === "company") {
          try {
            // console.log(email, password, selectOption, selectedType, userNumber, URL);
            const response = await axios.post(Company_URL, {
              headers: {
                "Ocp-Apim-Subscription-Key": "39f12545fd02451aa9e865348e0e4151",
              },
              name: selectOption,
              email: email,
              password: password,
              location: userAdress,
              income: 100000000,
              employee: userNumber,
            });
            console.log(response);                        
            ToastSuccess("회원가입에 성공하였습니다.");
            navigate("/login");
          } catch (error) {
            ToastError("회원가입에 실패했습니다.\n관리자에게 문의해주세요");
          }
        }
      } else {
        ToastWarning("모든 항목을 입력해주세요");
      }
    },
    [email, password, selectOption, navigate, selectedType, userNumber, userType, Company_URL, School_URL, userAdress],
  );
  return { onSignUpChange, email, password, onSignUpSubmit };
};
