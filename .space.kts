job("Qodana") {
   container("jetbrains/qodana-python") {
      env["QODANA_TOKEN"] = Secrets("qodana-token")
      shellScript {
         content = """
            QODANA_REMOTE_URL="ssh://git@git.${'$'}JB_SPACE_API_URL/${'$'}JB_SPACE_PROJECT_KEY/${'$'}JB_SPACE_GIT_REPOSITORY_NAME.git" \
            QODANA_BRANCH=${'$'}JB_SPACE_GIT_BRANCH \
            QODANA_REVISION=${'$'}JB_SPACE_GIT_REVISION \
            qodana
         """.trimIndent()
      }
   }
}
