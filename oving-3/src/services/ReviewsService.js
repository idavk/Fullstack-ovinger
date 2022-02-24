import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:3000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  getReviews() {
    return apiClient.get("/events");
  },
  getReview(id) {
    return apiClient.get("/events/" + id);
  },
};
