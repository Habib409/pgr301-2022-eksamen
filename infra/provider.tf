terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.40.0"
    }
  }
  backend "s3" {
    bucket = "analytics-1031"
    key    = "1031/cloudwatch-alarm.state"
    region = "eu-west-1"
  }

}