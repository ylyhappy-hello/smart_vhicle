<template>
  <div>
    <video class="video-js source-video-box" muted loop controls>
      <source :src="sourceVideo" type="video/mp4">
    </video>
    <video class="video-js target-video-box" muted loop controls>
      <source :src="detectVideo" type="video/mp4">
    </video>
  </div>
</template>

<script>
export default {
  name: "index.vue",
  data() {
    return {
      sourceVideo: this.$route.query.video_url,
      detectVideo: this.$route.query.detect_video_url
    }
  }
}

</script>

<style scoped>
.source-video-box, .target-video-box {
  width: 840px;
  height: 460px;
}

</style>
