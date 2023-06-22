import Swal from "sweetalert2";

export const Toast = Swal.mixin({
  toast: true,
  position: "top-end",
  showConfirmButton: false,
  timer: 2500,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener("mouseenter", Swal.stopTimer);
    toast.addEventListener("mouseleave", Swal.resumeTimer);
  },
});

export const ToastSuccess = (title) => {
  Toast.fire({
    icon: "success",
    title: title,
  });
};

export const ToastError = (title) => {
  Toast.fire({
    icon: "error",
    title: title,
  });
};

export const ToastWarning = (title) => {
  Toast.fire({
    icon: "warning",
    title: title,
  });
};
