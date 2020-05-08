package stackoverflow;

public class Question12 {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"id2\": 2,\n" +
                "  \"bDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "  \"eDate\": \"9999-12-31T00:00\",\n" +
                "  \"cDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "  \"use\": \"1\",\n" +
                "  \"act\": true,\n" +
                "  \"in\": 0,\n" +
                "  \"vDt\": null,\n" +
                "  \"vDt2\": null,\n" +
                "  \"dCheck\": null,\n" +
                "  \"vFlag\": true,\n" +
                "  \"nFlag\": false,\n" +
                "  \"vFlag2\": false,\n" +
                "  \"nFlag2\": false,\n" +
                "  \"uFlag\": true,\n" +
                "  \"rFlag\": false,\n" +
                "  \"dId\": 1,\n" +
                "  \"it\": 1,\n" +
                "  \"rId\": 1,\n" +
                "  \"rCode\": \"1\",\n" +
                "  \"iNum\": \"1\",\n" +
                "  \"iAb\": \"OOO\\\"TEST-1 \\\"TEST\\\"\",\n" +
                "  \"dId3\": 2,\n" +
                "  \"dId4\": 2,\n" +
                "  \"dName\": \"Test\",\n" +
                "  \"vId5\": null,\n" +
                "  \"vId6\": null,\n" +
                "  \"pDt7\": null,\n" +
                "  \"pDt8\": null,\n" +
                "  \"vDt9\": null,\n" +
                "  \"vDt10\": null,\n" +
                "  \"wCnt\": null,\n" +
                "  \"dId8\": null,\n" +
                "  \"dId9\": null,\n" +
                "  \"dName10\": null,\n" +
                "  \"dName11\": \"Test\",\n" +
                "  \"cReason\": null,\n" +
                "  \"vd12\": null,\n" +
                "  \"vId13\": null,\n" +
                "  \"vNum14\": null,\n" +
                "  \"vDate15\": null,\n" +
                "  \"act\": null,\n" +
                "  \"rLst\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"id2\": 2,\n" +
                "      \"bDate\": \"2020-04-04T16:22:45.236460\",\n" +
                "      \"eDate\": \"9999-12-31T00:00\",\n" +
                "      \"cDate\": \"2020-04-04T16:22:45.236460\",\n" +
                "      \"user\": \"1\",\n" +
                "      \"vId\": 1,\n" +
                "      \"vId2\": 1,\n" +
                "      \"dId\": 2,\n" +
                "      \"dId2\": 2,\n" +
                "      \"dName\": \"TTT\",\n" +
                "      \"pDt\": null,\n" +
                "      \"pDt2\": null,\n" +
                "      \"vDt\": null,\n" +
                "      \"vDt2\": null,\n" +
                "      \"cBegin\": \"2020-05-04T00:00:00\",\n" +
                "      \"cEnd\": \"2020-05-05T00:00:00\",\n" +
                "      \"cNum\": \"111\",\n" +
                "      \"amount\": 0,\n" +
                "      \"amount2\": 0,\n" +
                "      \"prem\": 0,\n" +
                "      \"f\": 0,\n" +
                "      \"pen\": 0,\n" +
                "      \"dId5\": 1,\n" +
                "      \"dName6\": \"Test\",\n" +
                "      \"aFlag\": false,\n" +
                "      \"rId\": 11,\n" +
                "      \"rCode\": \"11\",\n" +
                "      \"cNum\": 0,\n" +
                "      \"dId7\": 1,\n" +
                "      \"pId8\": null,\n" +
                "      \"pId9\": null,\n" +
                "      \"act\": null\n" +
                "    }\n" +
                "  ],\n" +
                "  \"vCard\": {\n" +
                "    \"id\": 1,\n" +
                "    \"id2\": 1,\n" +
                "    \"bDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "    \"eDate\": \"9999-12-31T00:00\",\n" +
                "    \"cDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "    \"user\": \"1\",\n" +
                "    \"act\": true,\n" +
                "    \"invalid\": 0,\n" +
                "    \"rId\": 1,\n" +
                "    \"rCode\": \"1\",\n" +
                "    \"iName\": \"TEST \\\"TEST \\\"TEST\\\"\",\n" +
                "    \"iName2\": \"TEST\\\"TEST \\\"TEST\\\"\",\n" +
                "    \"rNum\": \"1\",\n" +
                "    \"in5\": \"1\",\n" +
                "    \"k77\": \"1\",\n" +
                "    \"og77\": \"11\",\n" +
                "    \"rBegin\": \"2009-09-28T00:00:00\",\n" +
                "    \"inDate\": \"2009-09-28T00:00:00\",\n" +
                "    \"outDate\": null,\n" +
                "    \"phone\": null,\n" +
                "    \"localAddress\": \"TEST\",\n" +
                "    \"email\": null,\n" +
                "    \"iStatus\": \"State\",\n" +
                "    \"sCode\": \"1\",\n" +
                "    \"iCode\": \"1\",\n" +
                "    \"oCode\": \"1\",\n" +
                "    \"cBegin5\": \"1900-01-01T00:00:00\",\n" +
                "    \"pName\": null,\n" +
                "    \"pName2\": null,\n" +
                "    \"pReg\": null,\n" +
                "    \"action\": null,\n" +
                "    \"vList\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"id2\": \"1\",\n" +
                "        \"cCode\": \"1\",\n" +
                "        \"vId\": 1,\n" +
                "        \"vId2\": 1,\n" +
                "        \"bDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "        \"eDate\": \"9999-12-31T00:00\",\n" +
                "        \"cDate\": \"2020-04-04T16:22:45.032087\",\n" +
                "        \"user\": \"1\",\n" +
                "        \"actual\": true,\n" +
                "        \"rId\": 1,\n" +
                "        \"rCode\": \"1\",\n" +
                "        \"came\": \"ТTEST\",\n" +
                "        \"cPhone\": null,\n" +
                "        \"cP\": \"TEST\",\n" +
                "        \"action\": null\n" +
                "      }\n" +
                "    ],\n" +
                "    \"vList2\": []\n" +
                "  },\n" +
                "  \"vList3\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"id2\": 1,\n" +
                "      \"bDate\": \"2020-04-04T16:22:45.095369\",\n" +
                "      \"eDate\": \"9999-12-31T00:00\",\n" +
                "      \"cDate\": \"2020-04-04T16:22:45.095369\",\n" +
                "      \"user\": \"1\",\n" +
                "      \"actual\": true,\n" +
                "      \"vId\": 1,\n" +
                "      \"vId\": 1,\n" +
                "      \"tNum\": \"1\",\n" +
                "      \"surname\": \"TEST\",\n" +
                "      \"name\": \"TEST\",\n" +
                "      \"pat\": \"TEST\",\n" +
                "      \"pName2\": \"TEST\",\n" +
                "      \"phone\": null,\n" +
                "      \"kId\": 1,\n" +
                "      \"kId2\": 1,\n" +
                "      \"vChecks\": \"TEST\",\n" +
                "      \"nFlag\": false,\n" +
                "      \"vFlag\": true,\n" +
                "      \"nFlag2\": false,\n" +
                "      \"vFlag2\": false,\n" +
                "      \"action\": null\n" +
                "    }\n" +
                "  ],\n" +
                "  \"vList5\": []\n" +
                "}";




    }
}
