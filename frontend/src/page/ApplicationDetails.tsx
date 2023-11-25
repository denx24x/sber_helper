import { Col, Row } from "@salutejs/plasma-ui";
import React, { ReactNode } from "react";
import ApplicationCard from "../components/ApplicationCard";
import { Application, Status } from "../model/Application";
import { NavigateFunction, useNavigate } from "react-router-dom";
import { JsxElement } from "typescript";

function ApplicationDetails (props : {}) {
    const navigate : NavigateFunction = useNavigate();
    return (
        <>
            <Col style={{
              alignSelf: 'center',
              width: "50%"
            }}>
                    123
            </Col>
        </>
      );
    }
  
  export default ApplicationDetails;
  
  