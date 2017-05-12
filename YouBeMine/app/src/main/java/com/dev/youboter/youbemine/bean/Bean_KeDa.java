package com.dev.youboter.youbemine.bean;

import java.util.List;

/**
 * Created by zhengdongdong on 2017/5/12.
 */

public class Bean_KeDa {


    /**
     * moreResults : [{"rc":0,"answer":{"type":"T","text":"唱歌，歌唱是一门艺术，要想提高人们学唱歌的能力，应给予他们唱歌技巧的训练，训练的内容包括∶好学歌唱歌的姿势、呼吸、气息、发声和咬字等各方面的要求等。"},"service":"baike","text":"唱歌","operation":"ANSWER"}]
     * webPage : {"header":"","url":"http://kcbj.openspeech.cn/service/iss?wuuid=2eb903edf6d74b0913691228101837a7&ver=2.0&method=webPage&uuid=f8fc54b118097eed3492554fdeb86fafquery"}
     * semantic : {}
     * rc : 0
     * operation : PLAY
     * service : music
     * data : {"result":[{"singer":"Gwen Stacy","sourceName":"自产音乐","name":"I''ll Splatter You Like Jackson Pollock","downloadUrl":"http://file.kuyinyun.com/group1/M00/80/E7/rBBGdVQJA_2ATs3cAAvCN1C-Z7Q944.mp3"},{"singer":"安东尼科里亚","sourceName":"自产音乐","name":"If Only","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/8F/rBBGdFQI9OuAYLWYAAvd-MLugJA084.mp3"},{"singer":"Eino Grn","sourceName":"自产音乐","name":"Ilta Saimaalla+En Afton Vid Mjrn+","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/A9/rBBGdFQJBAaAQ9DVAAvCN5X-4yk791.mp3"},{"singer":"Hannah Montana","sourceName":"自产音乐","name":"If We Were A Movie (hannah Montana)","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/8F/rBBGdFQI9OuAWjwuAAvB9bP-7V0596.mp3"},{"singer":"N Sync","sourceName":"自产音乐","name":"I''Ll Never Stop","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/A9/rBBGdFQJBAiAM6lJAAvLUqDPlBY983.mp3"},{"singer":"Modern Chart Toppers","sourceName":"自产音乐","name":"If Today Was Your Last Day(Singalong Version)","downloadUrl":"http://file.kuyinyun.com/group1/M00/80/CD/rBBGdVQI9PCAUX2GAAvCN0_muZA287.mp3"},{"singer":"Seppo Ruohonen(Tenor)","sourceName":"自产音乐","name":"Iltalaulu","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/A9/rBBGdFQJBAqAf9BaAAvCN-HfXlQ851.mp3"},{"singer":"Denzil","sourceName":"自产音乐","name":"If Only Alan Won The Pools(2006 Remastered Lp Version)","downloadUrl":"http://file.kuyinyun.com/group1/M00/CD/8F/rBBGdFQI9PKAYVAEAAvCN7NsPMU068.mp3"},{"singer":"Lil Flip","sourceName":"自产音乐","name":"I''m A Balla Flip My Chips(Album Version)","downloadUrl":"http://file.kuyinyun.com/group1/M00/80/E7/rBBGdVQJBBCAYecLAAvCN5VdrFk524.mp3"},{"singer":"Alfredo Correa Chamin Correa Gloria Estefan Israel Cachao Lopez Jorge Casas Juanito R.Marquez Luis Enrique","sourceName":"自产音乐","name":"If We Were Lovers","downloadUrl":"http://file.kuyinyun.com/group1/M00/80/CD/rBBGdVQI9POASrxkAAvCNwtqSLM923.mp3"}]}
     * text : 唱歌
     */

    private WebPageBean webPage;
    private SemanticBean semantic;
    private int rc;
    private String operation;
    private String service;
    private DataBean data;
    private String text;
    private List<MoreResultsBean> moreResults;

    public WebPageBean getWebPage() {
        return webPage;
    }



    public void setWebPage(WebPageBean webPage) {
        this.webPage = webPage;
    }

    public SemanticBean getSemantic() {
        return semantic;
    }

    public void setSemantic(SemanticBean semantic) {
        this.semantic = semantic;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MoreResultsBean> getMoreResults() {
        return moreResults;
    }

    public void setMoreResults(List<MoreResultsBean> moreResults) {
        this.moreResults = moreResults;
    }

    public static class WebPageBean {
        /**
         * header :
         * url : http://kcbj.openspeech.cn/service/iss?wuuid=2eb903edf6d74b0913691228101837a7&ver=2.0&method=webPage&uuid=f8fc54b118097eed3492554fdeb86fafquery
         */

        private String header;
        private String url;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class SemanticBean {
    }

    public static class DataBean {
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * singer : Gwen Stacy
             * sourceName : 自产音乐
             * name : I''ll Splatter You Like Jackson Pollock
             * downloadUrl : http://file.kuyinyun.com/group1/M00/80/E7/rBBGdVQJA_2ATs3cAAvCN1C-Z7Q944.mp3
             */

            private String singer;
            private String sourceName;
            private String name;
            private String downloadUrl;

            public String getSinger() {
                return singer;
            }

            public void setSinger(String singer) {
                this.singer = singer;
            }

            public String getSourceName() {
                return sourceName;
            }

            public void setSourceName(String sourceName) {
                this.sourceName = sourceName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDownloadUrl() {
                return downloadUrl;
            }

            public void setDownloadUrl(String downloadUrl) {
                this.downloadUrl = downloadUrl;
            }
        }
    }

    public static class MoreResultsBean {
        /**
         * rc : 0
         * answer : {"type":"T","text":"唱歌，歌唱是一门艺术，要想提高人们学唱歌的能力，应给予他们唱歌技巧的训练，训练的内容包括∶好学歌唱歌的姿势、呼吸、气息、发声和咬字等各方面的要求等。"}
         * service : baike
         * text : 唱歌
         * operation : ANSWER
         */

        private int rc;
        private AnswerBean answer;
        private String service;
        private String text;
        private String operation;

        public int getRc() {
            return rc;
        }

        public void setRc(int rc) {
            this.rc = rc;
        }

        public AnswerBean getAnswer() {
            return answer;
        }

        public void setAnswer(AnswerBean answer) {
            this.answer = answer;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public static class AnswerBean {
            /**
             * type : T
             * text : 唱歌，歌唱是一门艺术，要想提高人们学唱歌的能力，应给予他们唱歌技巧的训练，训练的内容包括∶好学歌唱歌的姿势、呼吸、气息、发声和咬字等各方面的要求等。
             */

            private String type;
            private String text;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
