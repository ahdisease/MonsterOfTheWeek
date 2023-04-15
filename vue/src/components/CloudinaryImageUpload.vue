<template>
  <div>
    <button v-on:click.prevent="showUploadWidget">Upload Files</button>
  </div>
</template>

<script>
export default {
  name: "cloudinary-image-upload",
  methods: {
    openUploadModal() {
      window.cloudinary.createUploadWidget(
        {
          cloud_name: "c19-lima-monster-of-the-week",
          api_key: 965275756759159,
          upload_preset: "hoigav4j",
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done uploading..: ", result.info);
          }
        }
      );
    },
    showUploadWidget() {
      return window.cloudinary.openUploadWidget(
        {
          cloud_name: "c19-lima-monster-of-the-week",
          api_key: 965275756759159,
          upload_preset: "hoigav4j",
          sources: ["local", "url"],
          showAdvancedOptions: false,
          cropping: true,
          multiple: false,
          defaultSource: "local",
          styles: {
            palette: {
              window: "#FFFFFF",
              windowBorder: "#90A0B3",
              tabIcon: "#0078FF",
              menuIcons: "#5A616A",
              textDark: "#000000",
              textLight: "#FFFFFF",
              link: "#0078FF",
              action: "#FF620C",
              inactiveTabIcon: "#0E2F5A",
              error: "#F44235",
              inProgress: "#0078FF",
              complete: "#20B832",
              sourceBg: "#E4EBF1",
            },
            fonts: {
              default: null,
              "sans-serif": {
                url: null,
                active: true,
              },
            },
          },
        },
        (err, info) => {
          if (!err) {
            console.log("Upload Widget event - ", info);
          }
        }
      );
    },
    // created() {
    //   const cloudinary = Document.createElement("script");
    //   cloudinary.setAttribute(
    //     "src",
    //     "https://widget.cloudinary.com/v2.0/global/all.js"
    //   );
    //   cloudinary.setAttribute("type", "text/javascript");
    //   event.currentTarget.paretnElement.appendChild(cloudinary);
    // },
  },
};
</script>

<style scoped>
iframe {
  display: relative;
}
</style>
