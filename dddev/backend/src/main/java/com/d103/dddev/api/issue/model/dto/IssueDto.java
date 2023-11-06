package com.d103.dddev.api.issue.model.dto;

import com.d103.dddev.api.issue.model.document.Issue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class IssueDto {

    public static class Create{

        @Data
        @ApiModel(value="이슈 생성", description = "이슈 생성 RequestBody")
        public static class Request{
            @ApiModelProperty(value="상위문서 ID")
            private String parentId;
            @ApiModelProperty(value="스프린트 ID")
            private Integer sprintId;
        }

        @Data
        @Builder
        public static class Response{
            private String message;
            private Integer status;
            private Issue issue;
        }
    }

    public static class List{
        @Data
        @Builder
        public static class Response{
            private String message;
            private Integer status;
            private ArrayList<Issue> issueList;
        }
    }

    public static class Detail{
        @Data
        @Builder
        public static class Response{
            private String message;
            private Integer status;
            private Issue issue;
        }
    }

    public static class Delete{
        @Data
        @Builder
        public static class Response{
            private String message;
            private Integer status;
        }
    }

    public static class Content{
        @Data
        @Builder
        public static class Request{
            private String title;
            private String content;
        }

        @Data
        @Builder
        public static class Response{
            private Integer status;
            private String message;
            private Issue issue;
        }
    }

    public static class Status{

        @Data
        @ApiModel(value="이슈 상태 변경", description = "이슈 진행 상태 변경 API")
        public static class Request{
            @ApiModelProperty(value="상태", example = "1")
            private Integer status;
        }

        @Data
        @Builder
        public static class Response{
            private Integer status;
            private String message;
            private Issue issue;
        }
    }

    public static class Connect{
        @Data
        @ApiModel(value ="상위 문서 연결 변경", description = "이슈 문서 연결 변경 API")
        public static class Request{
            @ApiModelProperty(value = "연결할 체크포인트 문서 ID")
            private String parentId;
        }

        @Data
        @Builder
        public static class Response{
            private Integer status;
            private String message;
            private Issue issue;
        }
    }

    public static class Time{
        @Data
        @ApiModel(value="이슈 문서 시간 변경", description = "이슈 문서 시간 변경 API")
        public static class Request{
            @ApiModelProperty(value="집중 시간", example = "1")
            private Integer workTime;
            @ApiModelProperty(value="연구 시간", example = "2")
            private Integer studyTime;
        }

        @Data
        @Builder
        public static class Response{
            private Integer status;
            private String message;
            private Issue issue;
        }
    }

    public static class Sprint{
        @Data
        @ApiModel(value="이슈 문서 스프린트 연결", description = "이슈 문서 스프린트 연결 API")
        public static class Request{
            @ApiModelProperty(value = "스프린트 ID" , example = "1")
            private Integer sprintId;
        }

        @Data
        @Builder
        public static class Response{
            private Integer status;
            private String message;
            private Issue issue;
        }
    }
}
