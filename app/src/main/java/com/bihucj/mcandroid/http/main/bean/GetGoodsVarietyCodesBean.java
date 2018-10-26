package com.bihucj.mcandroid.http.main.bean;

import java.util.List;

/**
 * Created by 孟晨 on 2018/10/26.
 */

public class GetGoodsVarietyCodesBean {
    /**
     * code : 200
     * messages : []
     * data : {"response":{"flag":true,
     * "rows":[
     * {"codeId":"01010k","codeName":"黑虎掌"},
     * {"codeId":"01010l","codeName":"榛蘑"},
     * {"codeId":"01010U","codeName":"红乳牛肝菌"}],
     * "pageNum":1},"time":1527132727938}
     */

    private int code;
    private DataBean data;
    private List<MessagesBean> messages;

    public static class MessagesBean {
        private int id;
        private String message;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<MessagesBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesBean> messages) {
        this.messages = messages;
    }

    public static class DataBean {
        /**
         * response : {"flag":true,"rows":[{"codeId":"010101","codeName":"香菇"},{"codeId":"010103","codeName":"平菇"},{"codeId":"010106","codeName":"白金针菇"},{"codeId":"010108","codeName":"白玉菇"},{"codeId":"010107","codeName":"杏鲍菇"},{"codeId":"010104","codeName":"姬菇"},{"codeId":"010105","codeName":"金针菇"},{"codeId":"010109","codeName":"蟹味菇"},{"codeId":"01010a","codeName":"海鲜菇"},{"codeId":"01010b","codeName":"秀珍菇"},{"codeId":"01010c","codeName":"鸡腿菇"},{"codeId":"01010d","codeName":"黄牛杆菌"},{"codeId":"01010e","codeName":"黑牛肝"},{"codeId":"01010f","codeName":"美味牛肝"},{"codeId":"01010g","codeName":"白乳牛肝"},{"codeId":"01010h","codeName":"松茸"},{"codeId":"01010i","codeName":"松蘑"},{"codeId":"01010j","codeName":"干巴菌"},{"codeId":"01010k","codeName":"黑虎掌"},{"codeId":"01010l","codeName":"榛蘑"},{"codeId":"01010m","codeName":"元蘑"},{"codeId":"01010n","codeName":"人工元蘑"},{"codeId":"01010o","codeName":"野生元蘑"},{"codeId":"01010p","codeName":"珊瑚菌"},{"codeId":"01010q","codeName":"金福菇"},{"codeId":"01010r","codeName":"长根菇"},{"codeId":"01010s","codeName":"大杯香菇"},{"codeId":"01010t","codeName":"双孢菇"},{"codeId":"01010u","codeName":"茶树菇"},{"codeId":"01010v","codeName":"猪肚菇"},{"codeId":"01010w","codeName":"猴头菇"},{"codeId":"01010x","codeName":"滑子菇"},{"codeId":"01010y","codeName":"草菇"},{"codeId":"01010z","codeName":"鹿茸菇"},{"codeId":"01010A","codeName":"百灵菇"},{"codeId":"01010B","codeName":"鲍鱼菇"},{"codeId":"01010C","codeName":"虫草花"},{"codeId":"01010D","codeName":"大球盖菇"},{"codeId":"01010E","codeName":"灰树花"},{"codeId":"01010F","codeName":"银耳"},{"codeId":"01010G","codeName":"毛木耳"},{"codeId":"01010H","codeName":"黑木耳"},{"codeId":"01010I","codeName":"木耳"},{"codeId":"01010J","codeName":"姬松茸"},{"codeId":"01010K","codeName":"榆黄蘑"},{"codeId":"01010L","codeName":"老人头"},{"codeId":"01010M","codeName":"块菌"},{"codeId":"01010N","codeName":"鸡油菇"},{"codeId":"01010O","codeName":"鸡枞菌"},{"codeId":"01010P","codeName":"竹荪"},{"codeId":"01010Q","codeName":"竹荪蛋"},{"codeId":"01010R","codeName":"竹荪抬"},{"codeId":"01010S","codeName":"羊肚菌"},{"codeId":"01010T","codeName":"牛肝菌"},{"codeId":"01010U","codeName":"红乳牛肝菌"}],"pageNum":1}
         * time : 1527132727938
         */

        private ResponseBean response;
        private long time;

        public ResponseBean getResponse() {
            return response;
        }

        public void setResponse(ResponseBean response) {
            this.response = response;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public static class ResponseBean {
            /**
             * flag : true
             * rows : [{"codeId":"010101","codeName":"香菇"},{"codeId":"010103","codeName":"平菇"},{"codeId":"010106","codeName":"白金针菇"},{"codeId":"010108","codeName":"白玉菇"},{"codeId":"010107","codeName":"杏鲍菇"},{"codeId":"010104","codeName":"姬菇"},{"codeId":"010105","codeName":"金针菇"},{"codeId":"010109","codeName":"蟹味菇"},{"codeId":"01010a","codeName":"海鲜菇"},{"codeId":"01010b","codeName":"秀珍菇"},{"codeId":"01010c","codeName":"鸡腿菇"},{"codeId":"01010d","codeName":"黄牛杆菌"},{"codeId":"01010e","codeName":"黑牛肝"},{"codeId":"01010f","codeName":"美味牛肝"},{"codeId":"01010g","codeName":"白乳牛肝"},{"codeId":"01010h","codeName":"松茸"},{"codeId":"01010i","codeName":"松蘑"},{"codeId":"01010j","codeName":"干巴菌"},{"codeId":"01010k","codeName":"黑虎掌"},{"codeId":"01010l","codeName":"榛蘑"},{"codeId":"01010m","codeName":"元蘑"},{"codeId":"01010n","codeName":"人工元蘑"},{"codeId":"01010o","codeName":"野生元蘑"},{"codeId":"01010p","codeName":"珊瑚菌"},{"codeId":"01010q","codeName":"金福菇"},{"codeId":"01010r","codeName":"长根菇"},{"codeId":"01010s","codeName":"大杯香菇"},{"codeId":"01010t","codeName":"双孢菇"},{"codeId":"01010u","codeName":"茶树菇"},{"codeId":"01010v","codeName":"猪肚菇"},{"codeId":"01010w","codeName":"猴头菇"},{"codeId":"01010x","codeName":"滑子菇"},{"codeId":"01010y","codeName":"草菇"},{"codeId":"01010z","codeName":"鹿茸菇"},{"codeId":"01010A","codeName":"百灵菇"},{"codeId":"01010B","codeName":"鲍鱼菇"},{"codeId":"01010C","codeName":"虫草花"},{"codeId":"01010D","codeName":"大球盖菇"},{"codeId":"01010E","codeName":"灰树花"},{"codeId":"01010F","codeName":"银耳"},{"codeId":"01010G","codeName":"毛木耳"},{"codeId":"01010H","codeName":"黑木耳"},{"codeId":"01010I","codeName":"木耳"},{"codeId":"01010J","codeName":"姬松茸"},{"codeId":"01010K","codeName":"榆黄蘑"},{"codeId":"01010L","codeName":"老人头"},{"codeId":"01010M","codeName":"块菌"},{"codeId":"01010N","codeName":"鸡油菇"},{"codeId":"01010O","codeName":"鸡枞菌"},{"codeId":"01010P","codeName":"竹荪"},{"codeId":"01010Q","codeName":"竹荪蛋"},{"codeId":"01010R","codeName":"竹荪抬"},{"codeId":"01010S","codeName":"羊肚菌"},{"codeId":"01010T","codeName":"牛肝菌"},{"codeId":"01010U","codeName":"红乳牛肝菌"}]
             * pageNum : 1
             */

            private boolean flag;
            private int pageNum;
            private List<RowsBean> rows;

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public List<RowsBean> getRows() {
                return rows;
            }

            public void setRows(List<RowsBean> rows) {
                this.rows = rows;
            }

            public static class RowsBean {
                /**
                 * codeId : 010101
                 * codeName : 香菇
                 */

                private String codeId;
                private String codeName;

                public String getCodeId() {
                    return codeId;
                }

                public void setCodeId(String codeId) {
                    this.codeId = codeId;
                }

                public String getCodeName() {
                    return codeName;
                }

                public void setCodeName(String codeName) {
                    this.codeName = codeName;
                }
            }
        }
    }
}
