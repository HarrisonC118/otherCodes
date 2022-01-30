let BASE_URL = "";
const TIME_OUT = 10000;

if (process.env.NODE_ENV === "development") {
  BASE_URL =
    "https://www.fastmock.site/mock/657e07000910b05b5a3e83bca7d960f4/web";
}

export default {
  BASE_URL,
  TIME_OUT
};
