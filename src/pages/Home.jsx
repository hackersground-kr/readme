import React from "react";
import { EditInformation } from "../components/School/EditInformation";
import { EditIntroduce } from "../components/School/EditIntroduce";
import { SchoolSideBar } from "../components/School/SchoolSideBar";
// import axios from "axios";

export const HomePage = () => {
  // const [userType, setUserType] = useState("");

  // const URL = `https://readme-api-manager.azure-api.net/search/demand/search?name=IT/정보통신업`;
  // useEffect(() => {
  //   const UserType = async () => {
  //     const response = await axios.get(URL, {
  //       headers: {
  //         Authorization: localStorage.getItem("accessToken"),
  //       },
  //     });
  //     console.log(response.data.data);
  //     setUserType(response.data.data);
  //   };
  //   UserType();
  // }, [URL]);
  return (
    <div>
      <SchoolSideBar />
      <EditInformation />
      <EditIntroduce />
    </div>
  );
};
